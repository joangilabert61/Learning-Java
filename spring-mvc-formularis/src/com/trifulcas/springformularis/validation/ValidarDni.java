package com.trifulcas.springformularis.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = ValidarDniReglasValidacion.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarDni {
	String message() default "DNI inv�lido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
