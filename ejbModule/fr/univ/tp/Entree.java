package fr.univ.tp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity(name ="Entree")
public class Entree implements Serializable {

	private static final long serialVersionUID = -8420604818625234910L;

	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="date")
    private Date date;
    @Column(name="priority")
    private int priority;
    @Column(name="estimation")
    private int estimation;
    @Column(name="description")
    private String description;
    @Column(name="commentaires")
    private ArrayList<String> commentaires;
    
	public Entree(String name, Date date, int priority, int estimation,
			String description) {
		super();
		this.name = name;
		this.date = date;
		this.priority = priority;
		this.estimation = estimation;
		this.description = description;
		this.commentaires = new ArrayList<String>();
	}

	public Entree() {
		super();
		this.commentaires = new ArrayList<String>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public ArrayList<String> getCommentaires() {
		return commentaires;
	}
	
	public void addCommentaire(String commentaire) {
		this.commentaires.add(commentaire);
	}

	public void setCommentaires(ArrayList<String> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Entree [id=" + id + ", name=" + name + ", date=" + date
				+ ", priority=" + priority + ", estimation=" + estimation
				+ ", description=" + description + ", commentaires="
				+ commentaires + "]";
	}
}
