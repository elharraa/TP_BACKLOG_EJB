package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.Local;

import com.backlog.model.Comment;

@Local
public interface CommentDaoLocal {

	void addComment(Comment p);

	void editComment(Comment p);

	void deleteComment(int id);

	List<Comment> getAllComments();

	Comment getComment(int id);

}
