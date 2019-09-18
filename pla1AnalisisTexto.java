package pla1AnalisisTexto;

import java.util.Scanner;							//La faig servir per introduir text
import java.text.Collator;							//la faig servir per comparar strings
import java.util.ArrayList; 						//la faig servir per treballar facilment amb els arraylist

//Seis. Seis Cinco. Seis cinco cuatro. seis cinco cuatro tres. seis cinco cuatro tres dos. seis cinco cuatro tres dos uno. tres. dos dos.

public class pla1AnalisisTexto {
	
	public static void main(String[] args) 
	{
		
		ArrayList<String> taulaParaules = new ArrayList<String>();						// taula per a les paraules del text introduit.
		ArrayList<String> taulaFrases = new ArrayList<String>();						// taula per a les frases del text introduit.
		ArrayList<String> taulaFrasesLen = new ArrayList<String>();						// Taula per les frases ordenades per la llargada
		ArrayList<String> taulaFreqParaules = new ArrayList<String>();					// Taula per les paraules ordenades per frequencia
		ArrayList<String> taulaOrdenaParaulesRepeticions = new ArrayList<String>();		//resultat ordenacio paraules per freqüència
		
		String textIntroduit="";
		boolean treure_espais = true;

		Scanner entrada = new Scanner(System.in);						// Demana el text
		
		System.out.print("Introdueix el text: ");
		textIntroduit=entrada.nextLine();
	//------------------------------------------------------------------------------------------------------------------------------------	
		taulaParaules=descomposaText(textIntroduit," ");  				//Crea un arraylist de paraules separant-les pel caracter " "
		
		for (int z=0;z<taulaParaules.size();z++)						//Treu qualsevol caracter de les paraules que no sigui una lletra
			{															
			taulaParaules.set(z, netejaPuntuacions(taulaParaules.get(z),treure_espais));
			}
		imprimeixTaula(taulaParaules,"Llista de paraules del text original");									//Mostra la taula de paraules (tal qual)
	//------------------------------------------------------------------------------------------------------------------------------------	
		taulaFrases=descomposaText(textIntroduit,".");					//Crea un arraylist de frases separantles pel caracter "."
				
		for (int z=0;z<taulaFrases.size();z++)							//Treu qualsevol caracter de les frases que no sigui una lletra
			{
			taulaFrases.set(z, netejaPuntuacions(taulaFrases.get(z),!treure_espais));
			}
		imprimeixTaula(taulaFrases,"Lista de frases del text original");								//Mostra la taula de frases tal qual
	//------------------------------------------------------------------------------------------------------------------------------------		
				
		taulaFrases=ordenaFrasesPerLlargada(taulaFrases,true);				//Ordena la taula de frases per llargada de frases en ordre ascendent
		imprimeixTaulaLlargada(taulaFrases,"Llista de frases ordenades en orde ascendent de la seva llargada");									//Imprimeix la taula de frases ordenada per llargada en ordre invers
				
	//------------------------------------------------------------------------------------------------------------------------------------		
		
		taulaFreqParaules=paraulesPerFrequencia(taulaParaules);				//Troba les paráules úniques y la seva freqüencia.
		imprimeixTaula(taulaFreqParaules,"Freqüència d'aparició de les paraules:");
		
		System.out.println("Fi exercici");
						
	}
			//-------------------------------------------------------------------------------------------------------------------------------------------------
		// Comprova si el caracter llegit és un "." per tractarlo com a nova frase.al text d'entrada es una lletra vàlida y, si no ho és, ho considera separador de paraules
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		private static boolean esSeparador(String cadena, String separador)
		{
			boolean treballRetorn = false;
								
			Collator comparador = Collator.getInstance();
			comparador.setStrength(Collator.PRIMARY);
			
			// System.out.println("Cadena : " + cadena + " --- Separador: " + separador);
			
			if (comparador.compare(cadena, separador)==0)
				{treballRetorn=true;}
						
			if (treballRetorn) {return true;} else {return false;}  						
		}
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		// Comprova si el caracter llegit al text d'entrada es una lletra vàlida y, si no ho és, ho considera separador de paraules
		//-------------------------------------------------------------------------------------------------------------------------------------------------
			private static String netejaPuntuacions(String cadena, boolean treure_espais)
			{

				String separadorsParaules[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
				String cadenaTreball ="";
								
				Collator comparador = Collator.getInstance();
				comparador.setStrength(Collator.PRIMARY);
				
				for (int y=0;y<cadena.length();y++)
					{
					if (comparador.compare(cadena.substring(y, y+1), " ")==0)
						{
						if (!(treure_espais) && (y>1))
							{
							cadenaTreball=cadenaTreball + cadena.substring(y, y+1);
							}
						}
					else 
						{
						for (int x=0;x<separadorsParaules.length;x++)
							{
							if ((comparador.compare(cadena.substring(y, y+1), separadorsParaules[x])==0))
								{
								//System.out.println("caracter de la cadena: " + cadena.substring(y, y+1) + "  ---- Caracter separador: "+ separadorsParaules[x]);
								cadenaTreball=cadenaTreball + cadena.substring(y, y+1);
								}
							}
						}
					
					}
				return cadenaTreball;						
			}
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		// Rutina per introduir una text i descomposar-lo en paraules o frases (segons separador escollit) en un ArrayList sense el separadors
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		private static ArrayList<String> descomposaText(String textIntroduit, String separador)
		{
			ArrayList<String> taulaParaulesTreball = new ArrayList<String>();		// taula de treball per a les paraules del text introduit.
			taulaParaulesTreball.clear();
			boolean esSeparadorAnterior = true;
					
			taulaParaulesTreball.add("");
	
			
			for (int x=0;x<textIntroduit.length();x++)
				{
					
				if (esSeparador( textIntroduit.substring((x),x+1),separador ) )
					{
					if (!esSeparadorAnterior)							// treu separadors contigus duplicats, com ara una coma y un espai o varios espais
						{taulaParaulesTreball.add("");}
					
					esSeparadorAnterior=true;
					// System.out.println("Paraula nova " + x );
					}
				else
					{
						taulaParaulesTreball.set(taulaParaulesTreball.size()-1, taulaParaulesTreball.get(taulaParaulesTreball.size()-1) + (textIntroduit.substring((x),x+1)));
						esSeparadorAnterior=false;
						// System.out.println("Composant paraula " + x + " ---- " + taulaParaulesTreball.get(taulaParaulesTreball.size()-1));
					}
					
				}
			if (esSeparadorAnterior)													//Elimina el darrer que estará en blanc si era un separador.
				{taulaParaulesTreball.remove(taulaParaulesTreball.size()-1);}
			return taulaParaulesTreball;
		
		}
		//--------------------------------------------------------------------------------------------------------------------------------------
		// Visualitza els elements de la taula de paraules
		//--------------------------------------------------------------------------------------------------------------------------------------
		private static void imprimeixTaula(ArrayList<String> taulaParaulesTreball, String titol)
		{
			System.out.println("");
			System.out.println(titol + " : ");
			
			for (int x=0;x<taulaParaulesTreball.size();x++) 
				{
				System.out.println(x+1 + " -> " + taulaParaulesTreball.get(x));
				}
		}
		//--------------------------------------------------------------------------------------------------------------------------------------
		// Visualitza els elements de la taula de paraules
		//--------------------------------------------------------------------------------------------------------------------------------------
		private static void imprimeixTaulaLlargada(ArrayList<String> taulaParaulesTreball, String titol)
		{
			System.out.println("");
			System.out.println(titol + " : ");
			
			for (int x=0;x<taulaParaulesTreball.size();x++) 
				{
				System.out.println(x+1 + " -> " + taulaParaulesTreball.get(x).length() + " <- " + taulaParaulesTreball.get(x));
				}
		}
		//--------------------------------------------------------------------------------------------------------------------------------------
		// Ordena un arrayList per llargada en ordre ascendent o descendent
		//--------------------------------------------------------------------------------------------------------------------------------------
		private static ArrayList<String> ordenaFrasesPerLlargada (ArrayList<String> taulaFrasesTreball, boolean ascendent)
		{
			String fraseTreball="";								//Variable de treball per intercanvi de posicions
					
			if (taulaFrasesTreball.size()>1)
				{
				for (int x=taulaFrasesTreball.size()-1;x>=1;x--) 
					{
					for (int y=taulaFrasesTreball.size()-1;y>=(taulaFrasesTreball.size()-x);y--)
						{
						//System.out.println(x + " -> " + y);
						if (ascendent)
							{
							if (taulaFrasesTreball.get(y).length()<taulaFrasesTreball.get(y-1).length())
								{
								fraseTreball = taulaFrasesTreball.get(y-1);							// Guarda
								taulaFrasesTreball.set((y-1),taulaFrasesTreball.get(y));			// Puja la frase més llarga
								taulaFrasesTreball.set(y, fraseTreball);							// Baixa la més gran
								}	
							}
						else
							{
							if (taulaFrasesTreball.get(y).length()<taulaFrasesTreball.get(y-1).length())
								{
								fraseTreball = taulaFrasesTreball.get(y-1);							// Guarda
								taulaFrasesTreball.set((y-1),taulaFrasesTreball.get(y));			// Puja la frase més llarga
								taulaFrasesTreball.set(y, fraseTreball);							// Baixa la més petita
								}
							fraseTreball = taulaFrasesTreball.get(y-1);							// Guarda
							taulaFrasesTreball.set((y-1),taulaFrasesTreball.get(y));			// Puja la frase més llarga
							taulaFrasesTreball.set(y, fraseTreball);							// Baixa la més petita
							}	
						}
					
					}
				}
			return taulaFrasesTreball;
		}
		//--------------------------------------------------------------------------------------------------------------------------------------
		// Troba Paraules úniques i el número de cops que hi son
		//--------------------------------------------------------------------------------------------------------------------------------------
				private static ArrayList<String> paraulesPerFrequencia(ArrayList<String> taulaParaulesTreball)
				{
					ArrayList<String> taulaOrdenaParaulesRepeticions = new ArrayList<String>();				//resultat ordenacio paraules per freqüència
					
					ArrayList<String> taulaParaulesUniques = new ArrayList<String>();						// taula per a les paraules sense repeticions
					ArrayList<Integer> nombreParaulesUniques = new ArrayList<Integer>();					// taula per al nombre de repeticions de cada paraula.
					
					
					// System.out.println("Cercant paraules úniques....");
		
					
					for (int x=0;x<taulaParaulesTreball.size();x++) 										//Cerca cada paraula per acumular el nombre de cops que surt no case sentitive
						{
						if (taulaParaulesUniques.contains((taulaParaulesTreball.get(x).toLowerCase())))
							{
							nombreParaulesUniques.set(taulaParaulesUniques.indexOf((taulaParaulesTreball.get(x).toLowerCase())),nombreParaulesUniques.get(taulaParaulesUniques.indexOf((taulaParaulesTreball.get(x).toLowerCase())))+1);
							//System.out.println("Repetida: " + taulaParaulesTreball.get(x) + " en la posición " + taulaParaulesUniques.indexOf((taulaParaulesTreball.get(x).toLowerCase())) + " con repeticiones " + nombreParaulesUniques.get(taulaParaulesUniques.indexOf((taulaParaulesTreball.get(x).toLowerCase()))));
							}
						else
							{
							taulaParaulesUniques.add((taulaParaulesTreball.get(x).toLowerCase()));
							nombreParaulesUniques.add(1);
							}
							
						//System.out.println(x + " -> " + taulaParaulesUniques.get(x).length() + " <- " + taulaParaulesTreball.get(x));
						}
		
					// imprimeixTaula(taulaParaulesUniques,"Paraules úniques trobades:");
					
					taulaOrdenaParaulesRepeticions=ordenaParaulesRepeticions (taulaParaulesUniques, nombreParaulesUniques);
					
					
					return taulaOrdenaParaulesRepeticions;
				}


		//--------------------------------------------------------------------------------------------------------------------------------------
		// Ordena dos arraylist per llargada en ordre ascendent 
		//--------------------------------------------------------------------------------------------------------------------------------------
		private static ArrayList<String> ordenaParaulesRepeticions (ArrayList<String> taulaParaulesUniques, ArrayList<Integer> nombreParaulesUniques)
		{
			String fraseTreball="";								//Variable de treball per intercanvi de posicions
			int nombreTreball=0;
			
			ArrayList<String> taulaOrdenaParaulesRepeticions = new ArrayList<String>();				//resultat ordenacio paraules per freqüència
					
			if (taulaParaulesUniques.size()>1)
				{
				for (int x=taulaParaulesUniques.size()-1;x>=1;x--) 										//ordena per frecuencia en ordre descendent
					{
					for (int y=taulaParaulesUniques.size()-1;y>=(taulaParaulesUniques.size()-x);y--)
						{
						//System.out.println(x + " -> " + y);
						if (nombreParaulesUniques.get(y)>nombreParaulesUniques.get(y-1))
							{
							nombreTreball = nombreParaulesUniques.get(y-1);							// Guarda
							nombreParaulesUniques.set((y-1),nombreParaulesUniques.get(y));			// Puja la frase més llarga
							nombreParaulesUniques.set(y, nombreTreball);							// Baixa la més petita
							
							fraseTreball = taulaParaulesUniques.get(y-1);							// Guarda
							taulaParaulesUniques.set((y-1),taulaParaulesUniques.get(y));			// Puja la frase més llarga
							taulaParaulesUniques.set(y, fraseTreball);
							}
	
					//	fraseTreball = taulaFrasesTreball.get(y-1);							// Guarda
					//	taulaFrasesTreball.set((y-1),taulaFrasesTreball.get(y));			// Puja la frase més llarga
					//	taulaFrasesTreball.set(y, fraseTreball);							// Baixa la més petita
						
					//	System.out.println(x + " -> " + y);
						}
					
					}
				
					// imprimeixTaula(taulaParaulesUniques,"Paraules úniques per freqüència:");
					
				
				
					for (int x=taulaParaulesUniques.size()-1;x>=1;x--) 										//reordena ara per paraula en ordre alfabètic
						{
						for (int y=taulaParaulesUniques.size()-1;y>=(taulaParaulesUniques.size()-x);y--)
							{
							//System.out.println(x + " -> " + y);
							if ((nombreParaulesUniques.get(y)==nombreParaulesUniques.get(y-1)) && (taulaParaulesUniques.get(y).compareTo(taulaParaulesUniques.get(y-1))<0))
								{
								nombreTreball = nombreParaulesUniques.get(y-1);							// Guarda
								nombreParaulesUniques.set((y-1),nombreParaulesUniques.get(y));			// Puja la frase més llarga
								nombreParaulesUniques.set(y, nombreTreball);							// Baixa la més petita
							
							fraseTreball = taulaParaulesUniques.get(y-1);							// Guarda
							taulaParaulesUniques.set((y-1),taulaParaulesUniques.get(y));			// Puja la frase més llarga
							taulaParaulesUniques.set(y, fraseTreball);
							}
	
					//	fraseTreball = taulaFrasesTreball.get(y-1);							// Guarda
					//	taulaFrasesTreball.set((y-1),taulaFrasesTreball.get(y));			// Puja la frase més llarga
					//	taulaFrasesTreball.set(y, fraseTreball);							// Baixa la més petita
						
					//	System.out.println(x + " -> " + y);
						}
					
									
				
				
				}
			
			for (int y=0;y<(taulaParaulesUniques.size());y++)
				{
				taulaOrdenaParaulesRepeticions.add(nombreParaulesUniques.get(y) + " - " + taulaParaulesUniques.get(y));
				}
			}		
			return taulaOrdenaParaulesRepeticions;
			
		}
}