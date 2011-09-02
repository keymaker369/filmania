package org.seke.filmania.controller.validation;

import org.seke.filmania.model.AddCommentCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CommentValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return clazz == AddCommentCommand.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "prazanSadrzaj", "sadrzaj komentara ne moze biti prazan");
	}

}
