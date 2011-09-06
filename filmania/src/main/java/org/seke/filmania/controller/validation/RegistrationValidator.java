package org.seke.filmania.controller.validation;

import org.seke.filmania.model.RegistrationCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz == RegistrationCommand.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "prazanSadrzaj", "username polje ne moze biti prazno");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "prazanSadrzaj", "email polje ne moze biti prazno");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "prazanSadrzaj", "password polje ne moze biti prazno");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "prazanSadrzaj", "retypePassword polje ne moze biti prazno");
	}

}
