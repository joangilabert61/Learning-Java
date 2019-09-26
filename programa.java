package pla2JocsDeCartes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//-----------------------------------------------------------------
// Estructura base per fer proves de les clases que anem programant
//-----------------------------------------------------------------

public class programa {

	public static void main(String[] args) 
	{
		ArrayList<Jugador> TotsElsJugadors = new ArrayList<Jugador>();
		ArrayList<Carta> wCartesJugadors = new ArrayList<Carta>();
		Jugador wJugador;
		Carta wCarta;
		
		Scanner entrada = new Scanner(System.in);						
		String textIntroduit="";
		do
		{
			System.out.print("Introdueix el nom del jugador o XXX per sortir: ");
			textIntroduit=entrada.nextLine();
		
			switch (textIntroduit)
				{
				case "":
					System.out.println("Nom de jugador invàlid");
					break;
			
				case "XXX":	
					System.out.println("Fi d'entrada");
					textIntroduit="FINAL";
					break;
				
				default:
					TotsElsJugadors.add(new Jugador(textIntroduit));
					break;
				}
		}
	
	while (textIntroduit != "FINAL");
	
	if (TotsElsJugadors.size()>0) 
		{	
		
		System.out.println("Fi d'entrada de jugadors. Els seus noms son...");

		for (int x=0;x<TotsElsJugadors.size();x++) 
			{
			System.out.println(TotsElsJugadors.get(x).getNOMJUGADOR());
			}
	
		int valorEntrat=999;
	
		do
			{
			System.out.print("Entra el numero de cartes que vols repartir, de 1 a 5, o 0 per finalitzar: ");
			textIntroduit=entrada.nextLine();
			
		//	Jugador wJugador;
			
			if (esNumeroSencer(textIntroduit))
				{
				valorEntrat=Integer.parseInt(textIntroduit);
				if (valorEntrat >=1 || valorEntrat <=5)
					{
					System.out.print("Preparant RepartirCartes");
					
					for (int x=0;x<TotsElsJugadors.size();x++) 
						{
						System.out.println("Jugador - > " + TotsElsJugadors.get(x).getNOMJUGADOR());
						wCartesJugadors.clear();
						for (int y=0;y<valorEntrat;y++)
							{
							wCarta = sacarCarta();
							System.out.println(wCarta.toString());
							wCartesJugadors.add(new Carta(wCarta.getPal(), wCarta.getNom(), wCarta.getValor()));
							}
						
//						TotsElsJugadors.setCARTESJUGADOR(wCartesJugadors);
						}
					}
				else
					{
					System.out.println("Nombre de cartes incorrecte: ha de ser de 1 a 5.");
					}
				}
			else
				{
				System.out.println("El que has entrat no és un nùmero sencer");
				}
			}
			while (!esNumeroSencer(textIntroduit));
		}

	}						//Fi de main	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// Obté nombres aleatoris  en un rang per treue una carta
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	private static int NumAleatori (int Wminim, int Wmaxim) 
		{
		int r = (int)(Math.random()*Wmaxim+Wminim); 
		return r;
		}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// Demana PAL i Carta, per repartir
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	public static Carta sacarCarta() 
		{
		
		int wValors[] = {15,2,3,4,5,6,7,8,9,10,11,12,14};																	//Taula de numeros (no és necessària)	
		String wPals[] = {"piques","cors","diamants","trebols"};
		String wNoms[] = {"AS","2","3","4","5","6","7","8","9","10","J","Q","K"};
				
		int numPal = NumAleatori(0,wPals.length-1);
		int numCarta = NumAleatori(0,wNoms.length-1);
		//System.out.println("Pal -> " + wPals[numPal] + " ### Carta -> " + wNoms[numCarta] + " ### Valor-> " + wValors[numCarta]);
		
		return new Carta(wPals[numPal],wNoms[numCarta],wValors[numCarta]);
		}
	
    //-------------------------------------------------------------------------------------------------------------------------------------------------
	// Comprova que s'introdueix un número i aquest es sencer i vàlid
	//-------------------------------------------------------------------------------------------------------------------------------------------------
		private static boolean esNumeroSencer(String cadena)
			{
			try 
				{Integer.parseInt(cadena);
				return true;
				} 
			catch (NumberFormatException nfe)
				{return false;}
			}	
	
	
	
}
