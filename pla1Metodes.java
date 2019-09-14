package pla1Metodes;

import java.util.Scanner;

public class pla1Metodes {

	public static void main(String[] args) {
				
		// Escollir la opció del exercici de bucle a executar
		
				String cadena1="";
				String cadena2="";
				String cadena3="";
				
				int valorEntrat = 0;
				
				Scanner entrada = new Scanner(System.in);
				
				do
					{
					System.out.println("Entra una opció: 1= Cadena més llarga; 2= Comptar caracter en una cadena; 9= Sortir:");
					cadena1=entrada.nextLine();
					
					if (esNumeroSencer(cadena1))
						{
						valorEntrat=Integer.parseInt(cadena1);
						System.out.println("Opció escollida: " + valorEntrat);
						
						switch (valorEntrat)
							{
							case 1:
							
								//1.- Crear un método que pasándole dos cadenas, nos devuelva la cadena más larga. Ejemplo:
								// masLarga("hola","caracola") devuelve "caracola" 
							
								
								System.out.println("Crear un método que pasándole dos cadenas, nos devuelva la cadena más larga");
							
								do
									{
									System.out.println("Entra la primera frase:");
									cadena1=entrada.nextLine();
									}		
								while (cadena1.length()<= 0);
							
								do
									{
									System.out.println("Entra la segona frase:");
									cadena2=entrada.nextLine();
									}		
								while (cadena2.length() <= 0);
							
								System.out.println("La cadena més llarga és '" + cadenaMesLlarga(cadena1, cadena2) + "'.");
								System.out.println("Fi de comparació de cadenes amb un mètode");	
								break;
						
							case 2:	
							
								//2.- Crear un método que pasándole una letra y una cadena nos diga cuantas veces aparece esa letra en la cadena.
							
								System.out.println("Crear un método que pasándole una letra y una cadena nos diga cuantas veces aparece esa letra en la cadena.");
														
								do
									{
									System.out.println("Entra la cadena a tractar:");
									cadena1=entrada.nextLine();
									}		
								while (cadena1.length()<= 0);
							
								do
									{
									System.out.println("Entra el caracter a cercar:");
									cadena2=entrada.nextLine();
									}		
								while (cadena2.length() != 1);
							
							 	System.out.println("Em trobat " + numeroTrobats(cadena1, cadena2) + " cops el caracter '" + cadena2 + "' dins la cadena '" + cadena1 + "'.");
							
							
							 	System.out.println("Fi de bucle de cerca de caracters");
							 	break;
														
							case 9:
							
								System.out.println("Programa finalitzat.");
								break;
							
							default:
								System.out.println("Opció incorrecta");
							
							}								
						}			
					else
						{
						System.out.println(cadena1 + " no és un nombre vàlid.");
						valorEntrat=99;
						}
					}
			
					
				while (valorEntrat != 9);
				
				
			}

				
			private static boolean esNumeroSencer(String cadena)
			{
				try 
				{
					Integer.parseInt(cadena);
					return true;
				} 
				catch (NumberFormatException nfe)
				{
					return false;
				}
			}	
			
			private static String cadenaMesLlarga(String cadena2, String cadena3) 
			{
				if (cadena2.length() > cadena3.length())
					{
					System.out.println(cadena2.length() + " no és un nombre vàlid.");
					return cadena2;
					}
				else
					{	
					return cadena3;
					}
			}
			
			private static int numeroTrobats(String cadena2, String cadena3) 
			{
				int caracterActual=0;
				int numeroTrobats=0;
				String lletraCercar=cadena3;
				int trobatOn=0;
			
				while (caracterActual <= cadena2.length() && trobatOn >= 0 )
				{
					trobatOn=cadena2.indexOf(lletraCercar,caracterActual);
					if (trobatOn >= 0)
						{
						caracterActual=cadena2.indexOf(lletraCercar,caracterActual);
						numeroTrobats++;
						}
					caracterActual++;
				}
				return numeroTrobats;
			}

		}



