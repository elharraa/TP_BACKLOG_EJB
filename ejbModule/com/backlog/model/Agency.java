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

@Entity
@Table
@NamedQueries(@NamedQuery(name = "Agency.getAll", query = "SELECT e FROM Agency e "))
@SuppressWarnings("serial")

public class Agency implements Serializable {
	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column
	private int id;
	@Column
	private String name;
	
	public Agency() {
		super();
	}
	public Agency(String name) {
		super();
		this.name = name;
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