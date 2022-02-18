package com.proprojects.bookynotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proprojects.bookynotes.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	// power of spring framework
	public List<Book> findAll();
}
