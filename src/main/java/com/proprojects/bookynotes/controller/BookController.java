package com.proprojects.bookynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proprojects.bookynotes.entity.Book;
import com.proprojects.bookynotes.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService theBookService) {
		bookService = theBookService;
	}

	// show books main page route
	@GetMapping("/books")
	public String listBooks(Model theModel) {

		List<Book> theBooks = bookService.findAll();

		theModel.addAttribute("books", theBooks);

		return "list-books";
	}

	// show form to create new book
	@GetMapping("/books/new")
	public String showFormForNewEntry(Model theModel) {
		Book theBook = new Book();

		theModel.addAttribute("book", theBook);

		return "newbook";
	}

	// show form for update
	@RequestMapping(value = "/books/{bookId}/update", method = RequestMethod.GET)
	public String showFormForUpdateBook(@PathVariable("bookId") int theId, Model theModel) {
		Book theBook = bookService.findById(theId);

		theModel.addAttribute("book", theBook);

		return "editbook";
	}

	// handle form for update
	@PostMapping(value = "/books/update")
	public String handleFormForUpdateBook(@ModelAttribute("book") @Valid Book theBook, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "newbook";
		} else {

			bookService.save(theBook);

			// use a redirect to prevent duplicate submissions
			return "redirect:/books/" + theBook.getId();
		}
	}

	// show specific book route handler
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
	public String showBook(@PathVariable("bookId") int theId, Model theModel) {

		Book theBook = bookService.findById(theId);

		theModel.addAttribute("book", theBook);

		return "book";
	}

	// save new new book
	@PostMapping("/books/new/save")
	public String saveBook(@ModelAttribute("book") @Valid Book theBook, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "newbook";
		} else {

			bookService.save(theBook);

			// use a redirect to prevent duplicate submissions
			return "redirect:/books";
		}
	}

	@GetMapping("books/delete")
	public String delete(@RequestParam("bookId") int theId) {
		System.out.println("Entrou");
		System.out.println(theId);
		// delete the book
		bookService.deleteById(theId);

		// redirect to /books/list
		return "redirect:/books";

	}

}
