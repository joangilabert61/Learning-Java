package com.trifulcas.springformularis.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarDniReglasValidacion implements ConstraintValidator<ValidarDni, String>{

	@Override
	public void initialize(ValidarDni dni) 
		{
		//System.out.println("Creando instancia Validar DNI");
		}
	
	@Override
	public boolean isValid(String dni, ConstraintValidatorContext cxt) 
	
		{
		boolean valido = false;
		char[] letraDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	
		System.out.println("Validar DNI con " + dni);
		
		Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
		//dni="35038108T";
		Matcher mat = pat.matcher(dni);
	
		if (dni.length() <=0)
			{return false;}
		else
			{
			if (mat.matches()) 
				{
				char letra = Character.toUpperCase(dni.charAt(8));
				int numdni = Integer.parseInt(dni.substring(0, 8));
				valido = letra == letraDni[numdni % 23];
				}
			return valido;
			}
		}

}
