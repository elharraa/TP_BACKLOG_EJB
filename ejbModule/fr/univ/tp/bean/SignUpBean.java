package fr.univ.tp.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.univ.tp.dao.UtilisateurDao;
import fr.univ.tp.entity.Utilisateur;

@Named
@SessionScoped
public class SignUpBean implements Serializable {
	private static final long serialVersionUID = -8420604818625234910L;

	@EJB
	private UtilisateurDao utilisateurDao;
	
	
	private Utilisateur utilisateur;


	public void creerUtilisateur() {
		utilisateurDao.creerUtilisateur(utilisateur.getFirstname(),
				utilisateur.getLastname(), utilisateur.getEmail());
	}

	public void signIn(String email) throws IOException {
		Long id = utilisateurDao.signIn(email);
		if(id!= null)
		{
		}
	}

	/**
	 * Constructor
	 */
	public SignUpBean() {
		utilisateur = new Utilisateur();
	}
	
	/**
	 * Getters & Setters
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
