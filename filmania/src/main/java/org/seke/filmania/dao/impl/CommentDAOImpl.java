package org.seke.filmania.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.CommentDAO;
import org.seke.filmania.domain.Comment;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

@Repository(value = "commentDAO")
public class CommentDAOImpl implements CommentDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Comment saveComment(Comment comment) {
		if (comment.getCommentId().getId() == null)
			em.persist(comment);
		else
			em.merge(comment);
		return null;
	}

}
