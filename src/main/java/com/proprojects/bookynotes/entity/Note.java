package com.proprojects.bookynotes.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@NotBlank(message = "is required")
	@Column(name = "tile")
	private String title;

	@NotBlank(message = "is required")
	@Column(name = "body")
	private String body;

	@Column(name = "book")
	private String book;

	public Note(int id, @NotBlank(message = "is required") String title, @NotBlank(message = "is required") String body,
			String book) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

}
