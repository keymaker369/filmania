package org.seke.filmania.service;

import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.User;

public interface CommentService {

	public Comment saveComment(Comment comment, User user);
}
