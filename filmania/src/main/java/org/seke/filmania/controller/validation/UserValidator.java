package org.seke.filmania.controller.validation;

import org.seke.filmania.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz == User.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "prazanSadrzaj", "username polje ne moze biti prazno");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "prazanSadrzaj", "email polje ne moze biti prazno");
	}

}
