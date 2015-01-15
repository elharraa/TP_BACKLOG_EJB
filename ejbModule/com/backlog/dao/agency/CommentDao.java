package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backlog.model.Comment;

/**
 * Session Bean implementation class CommentDao
 */
@Stateless
@LocalBean
public class CommentDao implements CommentDaoLocal {

   
	
	
	@PersistenceContext
	private EntityManager em ; 
	
	

	@Override
	public void addComment(Comment p) {
	
		em.persist(p);
		
	}

	@Override
	public void editComment(Comment p) {
		
		em.merge(p) ; 
		
	}

	@Override
	public void deleteComment(int id) {
		
		em.remove(getComment(id));
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllComments() {
		
		  return em.createNamedQuery("Comment.getAll").getResultList();
	}

	@Override
	public Comment getComment(int id) {
		
		 return em.find(Comment.class, id);
		 
		
	}

  
    public CommentDao() {
        // TODO Auto-generated constructor stub
    }

}
