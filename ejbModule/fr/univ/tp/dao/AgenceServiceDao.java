package fr.univ.tp.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.univ.tp.entity.Agence;
import fr.univ.tp.entity.Entree;

/**
 * Session Bean implementation class UtilisateurServiceBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class AgenceServiceDao {

    @PersistenceContext
    private EntityManager em;

	public Agence creerAgence(String name) {
		Agence agence = new Agence(name);
        em.persist(agence);
		return agence;
	}

	public Agence chercheAgence(Long id) {
		Agence agence = em.find(Agence.class, id);
		return agence;
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
