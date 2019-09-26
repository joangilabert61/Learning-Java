package pla2JocsDeCartes;

import java.util.ArrayList;

public class Mus {

	BarajaEspanyola BarajaJoc = new BarajaEspanyola();
	ArrayList<Jugador> TotsElsJugadors = new ArrayList<Jugador>();
	
	void addjugador(Jugador wJugador) 
	{
		TotsElsJugadors.add(wJugador);
	}
	
}
