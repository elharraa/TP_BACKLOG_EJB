package fr.univ.tp.dao;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.univ.tp.entity.Entree;

/**
 * Session Bean implementation class UtilisateurServiceBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class EntreeDao {

    @PersistenceContext
    private EntityManager em;

	public Entree creerEntree(String name, Date date, int priority,
			int estimation, String description) {
		Entree entree = new Entree(name, date, priority, estimation, description);
		em.persist(entree);
		return entree;
	}

	public Entree chercheEntree(Long idEntree) {
		Entree entree = em.find(Entree.class, idEntree);
		return entree;
	}

	public void modifierEntree(Long idEntree, String name, Date date,
			int priority, int estimation, String description) {
		Entree entree = em.find(Entree.class, idEntree);
		if(name!=null) entree.setName(name);
		if(date!=null) entree.setDate(date);
		if(priority>0) entree.setPriority(priority);
		if(estimation>0) entree.setEstimation(estimation);
		if(description!=null) entree.setDescription(description);
		em.merge(entree);
	}

	public void ajoutCommentaire(Long idEntree, String commentaire) {
		Entree entree = em.find(Entree.class, idEntree);
		entree.addCommentaire(commentaire);
		em.merge(entree);
	}

	public void supprimerEntree(Long idEntree) {
		Entree entree = em.find(Entree.class, idEntree);
		em.remove(entree);		
	}
}
