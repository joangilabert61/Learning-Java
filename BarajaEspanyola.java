package pla2JocsDeCartes;

public class BarajaEspanyola extends Baraja{

	/**
	 * 
	 */
	public BarajaEspanyola() {
		super();
		// TODO Auto-generated constructor stub
		reiniciar();
	}

	void reiniciar()
	{
	if (CARTAS.size() > 0) {CARTAS.clear();}
	carrega();
	}

	void carrega() 
	{
		int wValors[] = {1,2,3,4,5,6,7,10,10,10};																	//Taula de numeros (no és necessària)	
		String wPals[] = {"oros","copas","espadas","bastos"};
		String wNoms[] = {"1","2","3","4","5","6","7","sota","caballo","Rey"};
	
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
