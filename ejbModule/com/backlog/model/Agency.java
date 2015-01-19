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
@NamedQueries(@NamedQuery(name = "Agency.getAll", query = "SELECT e FROM Agency e "))
@SuppressWarnings("serial")

public class Agency implements Serializable {
	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column
	private int id;
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@Column
	private String name;
	@Column
	private String creator;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Agency() {
		super();
	}
	public Agency(String name) {
		super();
		this.name = name;
	}
	public Agency(String name, String creator) {
		super();
		this.name = name;
		this.creator = creator;
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

}
