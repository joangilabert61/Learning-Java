package Pla7hibernate;

import java.util.Date;

import entidades.Alumnos;
import entidades.Modulos;
import entidades.Profesores;

public class Main {
	

	public static void main(String[] args) {       
		
		Date d=new Date();
		
		System.out.println(d.toString());

//		if (ProbarConexionBBDD.TestConnection())
		
//			{

			// --------------------------------------------------
			// Crear 2 Profesores
			// --------------------------------------------------
				
				Profesores wProfesor1 = bbddProfesores.crear("Joan 1 " + d.toString(), "01234567J", "profe1@gmail.com");
				Profesores wProfesor2 = bbddProfesores.crear("Joan 2 " + d.toString(), "12345678P", "profe2@gmail.com");
					
				bbddProfesores.lista(" ");
				
			// --------------------------------------------------
			// Crear 2 modulos con profesores distintos
			// --------------------------------------------------
					
				Modulos wModulo1 = bbddModulos.crear(wProfesor1, "OO-VBA");
				Modulos wModulo2 = bbddModulos.crear(wProfesor2, "VB.net");
				
				bbddModulos.lista("%");
		
			// --------------------------------------------------
			// Crear  tres alumnos, dos para el primer módulo y uno para el segundo, siendo los 2 primeros para el primer modulo y el otro para el segundo
			// --------------------------------------------------
		
			Alumnos wAlumno1 = bbddAlumnos.crear("Yo " + d.toString(), "yo@gmail.com", wModulo1);
			Alumnos wAlumno2 = bbddAlumnos.crear("Tu " + d.toString(), "tu@gmail.com", wModulo1);
			Alumnos wAlumno3 = bbddAlumnos.crear("El " + d.toString(), "el@gmail.com", wModulo2);
			
			bbddAlumnos.lista(" ");
			
			
		
//			}
//		else
//			{
//			System.out.println("Connexió fallida; cancelat!");
//			}
		}
}
