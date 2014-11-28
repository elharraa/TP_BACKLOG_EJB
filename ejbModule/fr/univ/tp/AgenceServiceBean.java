package fr.univ.tp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UtilisateurServiceBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class AgenceServiceBean implements AgenceService {

    @PersistenceContext
    private EntityManager em;

	@Override
	public Agence creerAgence(String name) {
		Agence agence = new Agence(name);
        em.persist(agence);
		return agence;
	}

	@Override
	public Agence chercheAgence(Long id) {
		Agence agence = em.find(Agence.class, id);
		return agence;
	}

	@Override
	public void ajoutEntree(Long idAgence, Entree entree) {
		Agence agence = em.find(Agence.class, idAgence);
		agence.addEntree(entree.getId(), entree);
	}

	@Override
	public void supprimeEntree(Long idAgence, Long idEntree) {
		Agence agence = em.find(Agence.class, idAgence);
		agence.removeEntree(idEntree);
	}

}
