package com.proprojects.bookynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proprojects.bookynotes.entity.Book;
import com.proprojects.bookynotes.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService theBookService) {
		bookService = theBookService;
	}

	@GetMapping("/books")
	public String listBooks(Model theModel) {

		// get employees from db
		List<Book> theBooks = bookService.findAll();

		// add to the spring model
		theModel.addAttribute("books", theBooks);

		return "list-books";
	}

	@GetMapping("/books/new")
	public String showFormForNewEntry(Model theModel) {
		Book theBook = new Book();

		theModel.addAttribute("book", theBook);

		return "newbook";
	}

}
