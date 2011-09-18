package org.seke.filmania.dao.impl;

import org.seke.filmania.dao.CommentDAO;
import org.seke.filmania.domain.Comment;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class CommentDAOImpl extends JpaDaoSupport implements CommentDAO {

	public Comment saveComment(Comment comment) {
		if (comment.getCommentId().getId() == null)
			getJpaTemplate().persist(comment);
		else
			getJpaTemplate().merge(comment);
		return null;
	}

}
