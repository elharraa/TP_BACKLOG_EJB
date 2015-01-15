package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backlog.model.Agency;

/**
 * Session Bean implementation class AgencyDao
 */
@Stateless
@LocalBean
public class AgencyDao implements AgencyDaoLocal {

	@PersistenceContext
	private EntityManager em ; 
	
	

	@Override
	public void addAgency(Agency p) {
	
		em.persist(p);
		
	}

	@Override
	public void editAgency(Agency p) {
		
		em.merge(p) ; 
		
	}

	@Override
	public void deleteAgency(int id) {
		
		em.remove(getAgency(id));
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Agency> getAllAgencies() {
		
		  return em.createNamedQuery("Agency.getAll").getResultList();
	}

	@Override
	public Agency getAgency(int id) {
		
		 return em.find(Agency.class, id);
		 
		
	}
	
	
	
	
    public AgencyDao() {
        // TODO Auto-generated constructor stub
    }

}
