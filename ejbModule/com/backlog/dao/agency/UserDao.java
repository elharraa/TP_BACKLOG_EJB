package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backlog.model.User;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
@LocalBean
public class UserDao implements UserDaoLocal {
	
	
	@PersistenceContext
	private EntityManager em ; 
	
	

	@Override
	public void addUser(User u) {
	
		em.persist(u);
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		  return em.createNamedQuery("User.getAll").getResultList();
	}

	@Override
	public User getUser(int id) {
		
		return em.find(User.class, id);
		 
		
	}

  
	
    public UserDao() {
    	

    	
    }

}
