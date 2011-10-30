package org.seke.filmania.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.CommentDAO;
import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.CommentId;
import org.springframework.stereotype.Repository;

@Repository(value = "commentDAO")
public class CommentDAOImpl implements CommentDAO {

	@PersistenceContext
	private EntityManager em;

	public Comment saveComment(Comment comment) {
		if (comment.getCommentId() == null || comment.getCommentId().getId() == null) {
			CommentId id = new CommentId(null, comment.getUser().getId(), comment.getMovie().getId());
			comment.setCommentId(id);
			em.persist(comment);
		} else
			em.merge(comment);
		return comment;
	}
}
