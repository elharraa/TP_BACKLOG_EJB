package fr.univ.tp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

@Entity(name ="Utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = -8420604818625234910L;

	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="lastname")
    private String lastname;
    @Column(name="firstname")
    private String firstname;
    @Column(name="email")
    private String email;
    
	public Utilisateur() {
		super();
	}
    
	

	public Utilisateur(String lastname, String firstname, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}



	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", email=" + email + "]";
	}
}
