package com.dorna.dornablog.domains.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dorna.dornablog.domains.User;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, User>{

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return user.getPassword().equals(user.getConfirmPassword());
	}

}
