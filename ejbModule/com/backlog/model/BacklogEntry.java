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


@SuppressWarnings("serial")
@Entity
@Table
@NamedQueries(@NamedQuery(name = "BacklogEntry.getAll", query = "SELECT e FROM BacklogEntry e" ) )

public class BacklogEntry implements Serializable {
	
	
	//   WHERE e.agencyId= :agencyId
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column
	private int id;
	@Column
	private int agencyId;
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@Column
	private String name;
	@Column
	private String creationDate;
	@Column
	private int priority;
	@Column
	private int estimation;
	@Column
	private String description;
	
	
	public BacklogEntry(int agencyId, String name, String creationDate,
			int priority, int estimation, String description) {
		super();
		this.agencyId = agencyId;
		this.name = name;
		this.creationDate = creationDate;
		this.priority = priority;
		this.estimation = estimation;
		this.description = description;
	}

	public BacklogEntry() {
		super();
	}
	
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
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
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getEstimation() {
		return estimation;
	}
	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
