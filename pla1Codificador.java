package pla1Codificador;

import java.util.ArrayList;
import java.util.Scanner;

public class pla1Codificador {

	public static void main(String[] args) 
	{

		int taulaNumeros[] = {0,1,2,3,4,5,6,7,8,9};																	//Taula de numeros (no és necessària)
		String taulaLletres[]= {" "," _"," ABC"," DEF"," GHI"," JKL"," MNO"," PQRS"," TUV"," WXYZ"};				//Taula de cractaer equivalents
		
		String textTeclat ="";																						//Entrada de teclat
		
		ArrayList<String> taulaCombinacions = new ArrayList<String>();												// taula per enmagatzemar les combinacions de decodificador.
		taulaCombinacions.clear();
		taulaCombinacions.add("");
		
		int opcioActual=0;															//Inicialitzem opció escoliida del menú
		Scanner entrada = new Scanner(System.in);
		do 
			{
			opcioActual=escollirMenu();												//mostrem y seleccionem la funció del menú
			switch (opcioActual)
				{
				case 1:																//Codificar una paraula en numeros
					textTeclat="";
					System.out.println("Entra un text:");
					textTeclat=entrada.nextLine().toUpperCase();	
					
					String textCodificat=codificar(taulaNumeros, taulaLletres, textTeclat);
					
					System.out.println("El text equival a les pulsacions entenent el valor x(y) com x=el número i y=nombre de pulsacions. ");
					System.out.println(textTeclat + " = " + textCodificat);
					
					System.out.println("Fi exercici");
					break;
					
					
				case 2:																// Descodificar un número en posibles paraules
					textTeclat="";
					System.out.println("Entra una combinació de nùmeros:");
					textTeclat=entrada.nextLine();	
					
					decodificar(taulaCombinacions, taulaLletres, textTeclat);
				
					System.out.println("Fi exercici");
					break;
				}
			}
		while (opcioActual != 9);

	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	//  Escollir opció de menú
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	private static int escollirMenu() 
	{
		String cadena1="";
		int valorEntrat = 0;
			
		Scanner entrada = new Scanner(System.in);
			
		do
			{
			System.out.println("Entra una opció: 1= Codificar; 2= Decodificar; 9= Sortir:");
			cadena1=entrada.nextLine();
				
			if (esNumeroSencer(cadena1))
				{
				valorEntrat=Integer.parseInt(cadena1);
				System.out.println("Opció escollida: " + valorEntrat);
					
				switch (valorEntrat)
					{
					case 1:
					case 2:
						return valorEntrat;
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
		
			return valorEntrat;

		}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// Comprova que s'introdueix un número i aquest es sencer i vàlid
	//-------------------------------------------------------------------------------------------------------------------------------------------------
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
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// Funció per cercar la tecla i nombre de pulsacions per representar cada lletra de la paraula
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	private static String codificar(int taulaNumeros[], String taulaLletres[], String textTeclat) 
		{			
		String treballSortida = "";
		char lletraEntrada;
			
		for (int y=0;y<textTeclat.length();y++)					//Per a cada lletra del text introduit..
			{
			lletraEntrada=textTeclat.charAt(y);
				
			for (int z=0;z<taulaNumeros.length;z++)				//Per a cada tecla vàlida			
				{
				String lletresValidar=taulaLletres[z];			//Cerca a la taula de lletres si la tecla correspon amb la lletra
										
				if (lletresValidar.indexOf(lletraEntrada) > 0)	//Si l'ha trobat, la guarda i trenca el bucle
					{
					treballSortida=treballSortida+z+"("+(lletresValidar.indexOf(lletraEntrada))+") " ;
					break;
					}
				}
			}
		return treballSortida;
			
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------	
	// Rutina per crear totes les posibles paraules resultants d'una combinació de nunmeros (de una sola pulsació)
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	private static void decodificar(ArrayList<String> taulaCombinacions, String taulaLletres[], String nombresIntroduits) 
	{
		String lletresTreball="";
		//System.out.println("Has introduit " + nombresIntroduits);
			
		for (int n=0;n<nombresIntroduits.length();n++)												//Per cada numero introduit amb el teclat
			{
			lletresTreball=taulaLletres[Integer.parseInt(nombresIntroduits.substring(n,n+1))];		//troba les lletres a les que correspon
			//System.out.println("Tractem " + lletresTreball);
			taulaCombinacions=crearCombinacio(taulaCombinacions, lletresTreball);					//crea un nivell per aquestes lletres i el guarda
			}
			imprimeixArray(taulaCombinacions);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	//	Crea la combinació les lletres del nivell existent amb les del nou número que es passa
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	private static ArrayList crearCombinacio(ArrayList<String> taulaCombinacionsEntrada, String textTreball) 
	{
		ArrayList<String> taulaCombinacionsSortida = new ArrayList<String>();						//Taula per construir el niu nivell de combinació
		taulaCombinacionsSortida.clear();
			
		for (int z=0;z<taulaCombinacionsEntrada.size();z++) 										//Per a cada combinació que ja existeix
			{
			//System.out.println("Combinant la la cadena " + textTreball + " amb una taula de " + taulaCombinacionsEntrada.size() + " elements");
			for (int x=1;x<textTreball.length();x++) 												//per a cada nova lletra a afegir combinació
				{
				taulaCombinacionsSortida.add(taulaCombinacionsEntrada.get(z) + textTreball.substring(x, x+1));   //crea una combinacio nova
				}
			}
		return taulaCombinacionsSortida;															//substitueix la taula de combinacions existent
	}
		
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// Imprimeix el contingut d'un array numérics integer (els n primers si passem un valor diferent a la variable MaximNumeros
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	private static void imprimeixArray(ArrayList<String> taulaTreball)
	{
		System.out.print("-------------------------------------------------------------------- ");
		for (int x=0;x<taulaTreball.size();x++) 
			{
			System.out.println("-> " + taulaTreball.get(x));
			}
	}
		
}
