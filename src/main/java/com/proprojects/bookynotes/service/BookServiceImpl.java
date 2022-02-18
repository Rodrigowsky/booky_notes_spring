package com.proprojects.bookynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proprojects.bookynotes.dao.BookRepository;
import com.proprojects.bookynotes.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepo;

	@Autowired
	public BookServiceImpl(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Book theBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
