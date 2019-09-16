package pla1Arrays;

import java.util.Scanner;							//La faig servir per introduir text
import java.util.Arrays;							//La faig servir per ordenar arrays
import java.text.Collator;							//la faig servir per comparar strings

public class pla1Arrays {

	public static void main(String[] args) 
	{
				
		int taulaNumeros[] =new int[10];					//Taula de numeros
		String taulaProductes[]=new String[5];				//Taula de productes
		
		for (int x=0;x<taulaProductes.length;x++) {taulaProductes[x]="";}		//Inicialitza la taula de productes
		
		int maximNumeros = taulaNumeros.length;				//Prepara el numerpo de items de la taula de numeros, encara que sabem que serà 10
		int maximProductes= taulaProductes.length;			//Prepara el numero de items de la taula de productes, encara que sabem que serà 5
			
		int opcioActual=0;									//Inicialitzem opció escoliida del menú
		do 
			{
			opcioActual=escollirMenu();						//mostrem y seleccionem la funció del menú
			switch (opcioActual)
				{
				case 1:										//Crear un programa que pida 10 números al usuario entre 1 y 10. Los guarde dentro de un array y finalmente muestre la suma de todos ellos.
					demanaArray(taulaNumeros,maximNumeros);		//demana array
					imprimeixArray(taulaNumeros,maximNumeros);	//visualitza l'array (y dona la suma)ç
					System.out.println(" dona un total de "+sumaArray(taulaNumeros,maximNumeros)); //Fa la suma (Perque volia fer un métode, no calia	
					System.out.println("Fi exercici");
					break;
				case 2:										// Modificar el programa anterior para que ordene el array de mayor a menor.
					demanaArray(taulaNumeros, maximNumeros);	//demana array	
					imprimeixArray(taulaNumeros,maximNumeros);	//visualitza l'array (y dona la suma)
					System.out.println("Ordenant els numeros");
					Arrays.sort(taulaNumeros);					//ordena l'array sobre ell mateix en ordre asc endent
				//	imprimeixArray(taulaNumeros,maximNumeros);	//Imprimeix l'array ordenat
					inverteixArray(taulaNumeros,maximNumeros);	//Inverteixo l'ordre
					imprimeixArray(taulaNumeros,maximNumeros);	//Imprimeix l'array ordenat
					System.out.println("Fi exercici");
					break;
				case 3:										//Crear un programa que le pida al usuario 5 nombres de productos y los guarde en un array. Si el usuario introduce un nombre repetido que lo vuelva a pedir.
					demanaProductes(taulaProductes, maximProductes); 
					imprimeixArrayProductes(taulaProductes, maximProductes);
					System.out.println("Fi exercici");
					break;
				}
			}
		while (opcioActual != 9);
	}

	// Mètode per crear opcions, demanar-les per pantalla, validarles i muntar al MAIN un case d'execució segons la opció
		
	private static int escollirMenu() 
	{
		String cadena1="";
		int valorEntrat = 0;
			
		Scanner entrada = new Scanner(System.in);
			
		do
			{
			System.out.println("Entra una opció: 1= Entrar i sumar valors; 2= Ordenar l'array; 3= Demanar noms de productes no duplicats ;9= Sortir:");
			cadena1=entrada.nextLine();
				
			if (esNumeroSencer(cadena1))
				{
				valorEntrat=Integer.parseInt(cadena1);
				System.out.println("Opció escollida: " + valorEntrat);
					
				switch (valorEntrat)
					{
					case 1:
					case 2:
					case 3:
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
	
		// Comprova que s'introdueix un número i aquest es sencer i vàlid
	
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
		
		//  Introducció per consola dels nombres sencers
		
		private static void demanaArray(int taulaNumerosTreball[], int maximNumeros)
		{
			String cadena1="";
			int valorEntrat = 0;
				
			Scanner entrada = new Scanner(System.in);
			
		//	System.out.println(maximNumeros);
			
			for (int x=0;x<maximNumeros;x++) 
				{
				do
				{
				System.out.print("Valor " + (x+1) +": ");
				cadena1=entrada.nextLine();
					
				if (esNumeroSencer(cadena1))
					{
						valorEntrat=Integer.parseInt(cadena1);
					
						if (valorEntrat >= 1 && valorEntrat <=10) 
							{
							System.out.println( valorEntrat);
							taulaNumerosTreball[x]=valorEntrat;
							}
						else
							{
							System.out.println("Valor invàlid.");
							}							
					}			
				else
					{
					System.out.println(cadena1 + " no és un nombre vàlid.");
					valorEntrat=99;
					
					}
				}
				while (valorEntrat <1 || valorEntrat >10);
				}
		}
		
		// Imprimeix el contingut d'un array numérics integer (els n primers si passem un valor diferent a la variable MaximNumeros
		
		private static void imprimeixArray(int taulaNumerosTreball[],int maximNumeros)
		{
			System.out.print("Array -> ");
			for (int x=0;x<maximNumeros;x++) 
				{
				System.out.print(" +" + taulaNumerosTreball[x]);
				}
			System.out.println(" <-");
			//	System.out.print(" dona " + sumaArray(taulaNumerosTreball,maximNumeros));
		}

		// Agafa un array de números sencers i inverteix les posicions; es pot fer dels n primers passant un número diferent a maximNumeros
		
		private static void inverteixArray(int taulaNumerosTreball[],int maximNumeros)
		{
			int itemActual=maximNumeros-1;
			int itemTreball=0;
			
			for (int x=0;x<maximNumeros/2;x++) 
				{
				itemTreball=taulaNumerosTreball[x];
				taulaNumerosTreball[x]=taulaNumerosTreball[itemActual];
				taulaNumerosTreball[itemActual]=itemTreball;
				itemActual--;
				}
			//	System.out.print(" dona " + sumaArray(taulaNumerosTreball,maximNumeros));
		}
		
		// Suma els valors sencers del array; es poden fer només el n primers passant un valor diferent a maximNumeros
		
		private static int sumaArray(int taulaNumerosTreball[], int maximNumeros)
		{
			int sumatreball=0;
			
			for (int x=0;x<maximNumeros;x++) {sumatreball=sumatreball+taulaNumerosTreball[x];}
			return sumatreball;
		}
		
		// Rutina per introduir noms de productes a un array sens permetre duplicats en els noms.
		
		private static void demanaProductes(String taulaProductesTreball[], int maximProductes)
		{
			String cadena1="";
			boolean duplicat=false;
			for (int x=0;x<taulaProductesTreball.length;x++) {taulaProductesTreball[x]="";}		//Inicialitza la taula de productes
							
			Scanner entrada = new Scanner(System.in);
			
		//	System.out.println(maximNumeros);
			
			for (int x=0;x<maximProductes;x++) 
				{
				do
					{
					System.out.print("Nom del producte: " + (x+1) +": ");
					cadena1=entrada.nextLine();
					duplicat=false;
					
					
					if (existeixProducte(taulaProductesTreball,x, cadena1))
						{
						System.out.println("Ja existeix un producte amb aquest nom.");
						duplicat=true;
						}							
						
					else
						{
						System.out.println( "Introduit -> " + cadena1);
						taulaProductesTreball[x]=cadena1;
						}
					}
					while (cadena1.length()<1 || duplicat );
				}
		}
		
		// Visualitza els elements de la taula de productes.
		
		private static void imprimeixArrayProductes(String taulaProductesTreball[],int maximProductes)
		{
			System.out.println("Taula de productes : ");
			for (int x=0;x<maximProductes;x++) 
				{
				System.out.println(x+1 + " -> " + taulaProductesTreball[x]);
				}
		}
		
		// Compara Strings cercar a la taula de productes un producte amb el mateix nom però sense importar accents o majúscules/minúscules
		
		private static boolean existeixProducte(String taulaProductesTreball[],int productesEntrats, String text)
		{
				
			Collator comparador = Collator.getInstance();
			comparador.setStrength(Collator.PRIMARY);
			
			for (int y=0;y<=productesEntrats;y++) 
				{	
				if (comparador.compare(taulaProductesTreball[y], text)==0)
					{
					return true;
					}
				}
			
				return false;
		}
}
