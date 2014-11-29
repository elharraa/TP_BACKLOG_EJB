package fr.univ.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.HashMap;

@Entity(name ="Agence")
public class Agence implements Serializable {

	private static final long serialVersionUID = -8420604818625234910L;

	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="backlog")
    private HashMap<Long,Entree> backlog;

	public Agence() {
		super();
		this.name = "null";
		this.backlog = new HashMap<Long,Entree>();
	}
    
	public Agence(String name) {
		super();
		this.name = name;
		this.backlog = new HashMap<Long,Entree>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Long, Entree> getBacklog() {
		return backlog;
	}
	
	public void addEntree(Long idEntree, Entree entree) {
		this.backlog.put(idEntree, entree);
	}
	
	public void removeEntree(Long idEntree) {
		this.backlog.remove(idEntree);
	}

	public void setBacklog(HashMap<Long, Entree> backlog) {
		this.backlog = backlog;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", name=" + name + "]";
	}
	
}
