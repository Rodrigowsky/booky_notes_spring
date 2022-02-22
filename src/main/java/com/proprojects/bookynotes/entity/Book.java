package com.proprojects.bookynotes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@NotNull(message = "is required")
	@Column(name = "pages")
	private Integer pages;

	@NotBlank(message = "is required")
	@Column(name = "description")
	private String description;

	@NotNull(message = "is required")
	@Min(0)
	@Max(5)
	@Column(name = "score")
	private Integer score;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "book")
	private List<Note> notes;

	public Book() {

	}

	public Book(String name, Integer pages, String description, Integer score) {
		this.name = name;
		this.pages = pages;
		this.description = description;
		this.score = score;
	}

	public Book(int id, String name, Integer pages, String description, Integer score) {
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

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void add(Note note) {
		if (this.notes == null) {
			this.notes = new ArrayList<>();
		}
		this.notes.add(note);

	}

}
