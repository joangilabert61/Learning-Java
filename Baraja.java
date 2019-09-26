package pla2JocsDeCartes;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Baraja {
	
	protected ArrayList<Carta> CARTAS = new ArrayList<Carta>(); 

	void Barajar() 
		{
		
		System.out.println("Llista Original : \n" + CARTAS);
		
		Collections.shuffle(CARTAS);
		
		System.out.println("Llista reordenada : \n" + CARTAS);
		}
	Carta Repartir() 
		{
		if (CARTAS.size()>0)
			{
			Carta wCartaDonada=CARTAS.get(0);
			CARTAS.remove(0);
			return wCartaDonada;
			}
		else
			{
			System.out.println("No hi ha més cartes per repartir.");
			return null;
			}
		}
	abstract void reiniciar();
			
		
}
