package pla2JocsDeCartes;

public class BarajaFrancesa extends Baraja{
	
	void reiniciar()
		{
		if (CARTAS.size() > 0) {CARTAS.clear();}
		carrega();
		}

	void carrega() 
		{
		int wValors[] = {1,2,3,4,5,6,7,8,9,10,10,10,10};																	//Taula de numeros (no és necessària)	
		String wPals[] = {"piques","cors","diamants","trebols"};
		String wNoms[] = {"AS","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for (int numPal=0;numPal<wPals.length;numPal++)
			{	
			for (int numCarta=0;numCarta<wNoms.length;numCarta++)
				{
				CARTAS.add(new Carta(wPals[numPal],wNoms[numCarta],wValors[numCarta]));
				System.out.println("Pal -> " + wPals[numPal] + " ### Carta -> " + wNoms[numCarta] + " ### Valor-> " + wValors[numCarta]);
				}
			}
		}
	
	
	
	
}
