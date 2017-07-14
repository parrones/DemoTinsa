package com.tinsa.demo.infrastructure.entry.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NotificationTypeValidator implements ConstraintValidator<ValidNotificationType, String>{

	private List<String> valueList;
	
	@Override
	public void initialize(ValidNotificationType constraintAnnotation) 
	{
		valueList = new ArrayList<String>();
        for(String val : constraintAnnotation.acceptedValues()) 
        {
            valueList.add(val.toUpperCase());
        }
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		if(StringUtils.isBlank(value) || !valueList.contains(value.toUpperCase())) 
		{
            return false;
        }
        return true;
	}
}
