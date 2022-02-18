package com.proprojects.bookynotes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@NotBlank(message = "is required")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "is required")
	@Column(name = "pages")
	private int pages;

	@NotBlank(message = "is required")
	@Column(name = "description")
	private String description;

	@Size(min = 0, max = 5, message = "Only between 0 and 5")
	private int score;

	public Book() {

	}

	public Book(String name, int pages, String description, int score) {
		this.name = name;
		this.pages = pages;
		this.description = description;
		this.score = score;
	}

	public Book(int id, String name, int pages, String description, int score) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.description = description;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
