package com.backlog.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
@NamedQueries(@NamedQuery(name = "Comment.getAll", query = "SELECT e FROM Comment e "))
@SuppressWarnings("serial")

public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column
	private int id;
	@Column
	private int userId;
	@Column
	private int entryId;
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@Column
	private String comment;
	@Column
	private String creationDate;

	public Comment() {
		super();
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comment(int userId, int entryId, String comment, String creationDate) {
		super();
		this.userId = userId;
		this.entryId = entryId;
		this.comment = comment;
		this.creationDate = creationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
