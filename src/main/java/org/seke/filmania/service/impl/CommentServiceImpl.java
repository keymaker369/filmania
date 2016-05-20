package org.seke.filmania.service.impl;

import org.seke.filmania.dao.CommentDAO;
import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.User;
import org.seke.filmania.service.CommentService;
import org.springframework.transaction.annotation.Transactional;

public class CommentServiceImpl implements CommentService {

	private CommentDAO commentDAO;

	private UserDAO userDAO;

	@Transactional
	public Comment saveComment(Comment comment, User user) {
		user = getUserDAO().getUser(user.getId());
		comment.setUser(user);
		return getCommentDAO().saveComment(comment);
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
