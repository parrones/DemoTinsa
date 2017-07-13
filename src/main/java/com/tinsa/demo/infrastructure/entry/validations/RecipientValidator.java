package com.tinsa.demo.infrastructure.entry.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class RecipientValidator implements ConstraintValidator<ValidRecipient, String>{

	private static final String DIGIT_REGEX = "\\d{9}";
	
	@Override
	public void initialize(ValidRecipient constraintAnnotation) 
	{
	}

	@Override
	public boolean isValid(String recipient, ConstraintValidatorContext context) 
	{
		if(StringUtils.isNotBlank(recipient))
		{
			if(recipient.matches(DIGIT_REGEX))
			{
				return true;
			}
		}
        return false;
	}
}
