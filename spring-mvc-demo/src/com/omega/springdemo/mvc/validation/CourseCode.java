package com.omega.springdemo.mvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ FIELD, METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	//
	public String[] value() default "LUV";

	// define default error message
	//
	public String message() default "must start with LUV";

	// define default groups
	//
	public Class<?>[] groups() default {};

	// define default payloads
	public Class<? extends Payload>[] payload() default {};
}
