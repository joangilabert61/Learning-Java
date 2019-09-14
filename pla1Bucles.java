package pla1Bucles;
import java.util.Scanner;

public class pla1Bucles {

	public static void main(String[] args) 
	{
	// Escollir la opció del exercici de bucle a executar
		
		String cadena1="";
		int valorEntrat = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do
			{
			System.out.println("Entra una opció: 1= bucle do-while; 2= blucle while-string indexof; 3= Bucle suma de nombres; 9= Sortir:");
			cadena1=entrada.nextLine();
			
			if (esNumeroSencer(cadena1))
				{
				valorEntrat=Integer.parseInt(cadena1);
				System.out.println("Opció escollida: " + valorEntrat);
				
				switch (valorEntrat)
					{
				case 1:
					
					//1.- Escribir un programa que pida un número al usuario entre 1 y 10. 
					//Si el usuario introduce un número que no esté en el rango, debe volver a pedirlo (Bucle do while)
						
					System.out.println("Escribir un programa que pida un número al usuario entre 1 y 10. Si el usuario introduce un número que no esté en el rango, debe volver a pedirlo (Bucle do while)");
					
					do
						{
						
						System.out.println("Entra un nùmero:");
						cadena1=entrada.nextLine();
						
						if (esNumeroSencer(cadena1))
							{
							valorEntrat=Integer.parseInt(cadena1);
							System.out.println("Valor: " + valorEntrat);
							}
						else
							{
							System.out.println(cadena1 + " no és un nombre sencer vàlid entre 1 i 10.");
							}
						}		
						while (valorEntrat <= 0 || valorEntrat >= 11);
					
					System.out.println("Fi de bucle do-while");	
					break;
				
				case 2:	
					
					//2.- Escribir un programa que nos pida una cadena y nos diga cuantas veces aparece la letra "a" (bucle while, string indexof)
					System.out.println("Escribir un programa que nos pida una cadena y nos diga cuantas veces aparece la letra \"a\" (bucle while, string indexof)");
					
					
					int caracterActual=0;
					int numeroTrobats=0;
					String lletraCercar="a";
					int trobatOn=0;
					
					System.out.println("Entra la cadena a tractar:");
					cadena1=entrada.nextLine();
					
					if (cadena1.length()>0) 
					
						{
						 while (caracterActual <= cadena1.length() && trobatOn >= 0 )
						 	{
							 trobatOn=cadena1.indexOf(lletraCercar,caracterActual);
							 if (trobatOn >= 0)
							 	{
								 caracterActual=cadena1.indexOf(lletraCercar,caracterActual);
								 numeroTrobats++;
							 	}
							 caracterActual++;
						 	}
						 System.out.println("Em trobat " + numeroTrobats + " cops el caracter '" + lletraCercar + "' dins la cadena '" + cadena1 + "'.");
						}
					
					else
						{
						System.out.println(cadena1 + " no és una cadena vàlida.");
						}
					
					System.out.println("Fi de bucle while, string indexof");
					break;
					
				case 3:
					
					// 3.- Escribir un programa que nos pida un número mayor de 1 y que nos diga la suma de todos los números hasta el número introducido. Por ejemplo, si introduce el 4: 1+2+3+4=10
					
					System.out.println("Escribir un programa que nos pida un número mayor de 1 y que nos diga la suma de todos los números hasta el número introducido. Por ejemplo, si introduce el 4: 1+2+3+4=10");

					double totalSuma=0;
					
					do
						{
						System.out.println("Entra un nombre més gran que 1:");
						cadena1=entrada.nextLine();
					
						if (esNumeroSencer(cadena1))
							{
							valorEntrat=Integer.parseInt(cadena1);
							if (valorEntrat>1) 
								{
								for(int i=1;i<=valorEntrat;i++) 
									{
									totalSuma=totalSuma+i;
									}
								System.out.println("El resultat de " + valorEntrat + " és " + totalSuma);
								}
									
							}
						else
							{
							System.out.println(cadena1 + " no és un nombre vàlid.");
							valorEntrat=99;
							}
						}
						while (valorEntrat <= 0);	
					
						System.out.println("Fi de bucle suma nombres");
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

}
