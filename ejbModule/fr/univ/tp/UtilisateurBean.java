package fr.univ.tp;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UtilisateurBean implements Serializable{
	private static final long serialVersionUID = -8420604818625234910L;

	@EJB
    private UtilisateurDao    utilisateurDao;
	
	private Utilisateur utilisateur;
	 private List<Utilisateur> listUsers;
	
	
	
	public List<Utilisateur> getListUsers() {
		return utilisateurDao.getUsers();
	}


	public void setListUsers(List<Utilisateur> listUsers) {
		this.listUsers = listUsers;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public void creerUtilisateur() {
		utilisateurDao.creerUtilisateur(utilisateur.getFirstname(), utilisateur.getLastname(), utilisateur.getEmail());
	}

	public UtilisateurBean() {
		utilisateur = new Utilisateur();
	}
	

}
