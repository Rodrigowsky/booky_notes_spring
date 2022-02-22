package com.proprojects.bookynotes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "notes")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@NotBlank(message = "is required")
	@Column(name = "title")
	private String title;

	@NotBlank(message = "is required")
	@Column(name = "body")
	private String body;

	public Note(int id, @NotBlank(message = "is required") String title,
			@NotBlank(message = "is required") String body) {

		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Note(@NotBlank(message = "is required") String title, @NotBlank(message = "is required") String body) {
		super();
		this.title = title;
		this.body = body;
	}

	public Note() {
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

	@Override
	public String toString() {
		return "Note [title=" + title + ", body=" + body + "]";
	}

}
