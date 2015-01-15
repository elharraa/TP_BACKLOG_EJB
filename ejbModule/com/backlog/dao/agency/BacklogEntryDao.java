package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backlog.model.BacklogEntry;

/**
 * Session Bean implementation class BacklogEntryDao
 */
@Stateless
@LocalBean
public class BacklogEntryDao implements BacklogEntryDaoLocal {

	
	
	@PersistenceContext
	private EntityManager em ; 
	
	

	@Override
	public void addBacklogEntry(BacklogEntry p) {
	
		em.persist(p);
		
	}

	@Override
	public void editBacklogEntry(BacklogEntry p) {
		
		em.merge(p) ; 
		
	}

	@Override
	public void deleteBacklogEntry(int id) {
		
		em.remove(getBacklogEntry(id));
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<BacklogEntry> getAllBacklogEntries() {
		
		  return em.createNamedQuery("BacklogEntry.getAll").getResultList();
	}

	@Override
	public BacklogEntry getBacklogEntry(int id) {
		
		 return em.find(BacklogEntry.class, id);
		 
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BacklogEntry> getAllBacklogEntries(int id) {
		
		return em.createNamedQuery("BacklogEntry.getAll").getResultList();
		//.setParameter("agencyId",com.backlog.vars.Vars.idAgency)
	}
  
	
    public BacklogEntryDao() {
        // TODO Auto-generated constructor stub
    }


}
