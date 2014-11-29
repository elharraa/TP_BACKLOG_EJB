package fr.univ.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.univ.tp.entity.Utilisateur;

 @Stateless
 @Local
public class UtilisateurDao {

    @PersistenceContext
    private EntityManager em;
    
    private Utilisateur utilisateur;

	public void creerUtilisateur(String firstname, String lastname, String email) {
        Utilisateur utilisateur = new Utilisateur(firstname, lastname, email);
        em.persist(utilisateur);
	}


	public Utilisateur chercheUtilisateur(Long id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
        return utilisateur;
	}
	
	public List<Utilisateur> getUsers() {
		Query req = em.createQuery("select p from Utilisateur p");
		List<Utilisateur> resultList = req.getResultList();
		return resultList;
	}


	public UtilisateurDao() {
		utilisateur = new Utilisateur();
	}


	public Utilisateur signIn(String email) {
		@SuppressWarnings("unchecked")
		List<Utilisateur> result =  em.createQuery(
		        "SELECT u FROM User u WHERE u.email = :email")
		        .setParameter("email", email)
		        .getResultList();
		if (result == null || result.isEmpty()) {
	        return null;
	    }

	    return result.get(0);
	}
	

}
