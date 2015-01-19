package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backlog.model.User;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
@LocalBean
public class UserDao implements UserDaoLocal {
	
//	@Inject
//	private Event<User> userEventSrc;
	
	@PersistenceContext
	private EntityManager em ; 
	
	

	@Override
	public void addUser(User u) {
	
		em.persist(u);
//		userEventSrc.fire(u);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		  return em.createQuery("select u from User u").getResultList();
	}

	@Override
	public User getUser(int id) {
		
		return em.find(User.class, id);
	}
  
    public UserDao() {
    }


	@SuppressWarnings("unchecked")
	@Override
	public User findByName(String userName) {
		List<User> result = em.createQuery("select a from User a where name = '"+userName+"'").getResultList();
		return result.isEmpty()?null:result.get(0);
	}

}
