package fr.univ.tp.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.univ.tp.entity.Agence;
import fr.univ.tp.entity.Entree;
import fr.univ.tp.entity.Agence;

/**
 * Session Bean implementation class UtilisateurServiceBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class AgenceDao {

    @PersistenceContext
    private EntityManager em;

	public Agence creerAgence(String name, Long userId) {
		Agence agence = new Agence(name, userId);
        em.persist(agence);
		return agence;
	}

	public List<Agence> getUserAgency(Long userId) {
		@SuppressWarnings("unchecked")
		List<Agence> result =  em.createQuery(
		        "SELECT a FROM Agence a WHERE a.id = :id")
		        .setParameter("id", userId)
		        .getResultList();
		if (result == null || result.isEmpty()) {
	        return null;
	    }

	    return result;
	}

	public void ajoutEntree(Long idAgence, Entree entree) {
		Agence agence = em.find(Agence.class, idAgence);
		agence.addEntree(entree.getId(), entree);
	}

	public void supprimeEntree(Long idAgence, Long idEntree) {
		Agence agence = em.find(Agence.class, idAgence);
		agence.removeEntree(idEntree);
	}

}
