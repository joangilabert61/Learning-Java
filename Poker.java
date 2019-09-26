package pla2JocsDeCartes;

import java.util.ArrayList;

public class Poker {

	BarajaFrancesa BarajaJoc = new BarajaFrancesa();
	ArrayList<Jugador> TotsElsJugadors = new ArrayList<Jugador>();
	
	void addjugador(Jugador wJugador) 
	{
		TotsElsJugadors.add(wJugador);
	}

	public Poker(BarajaFrancesa barajaJoc, ArrayList<Jugador> totsElsJugadors) {
		super();
		BarajaJoc = barajaJoc;
		Jugador WJugador = totsElsJugadors.get(1);
		try	{
			TotsElsJugadors = totsElsJugadors;
			}
		catch (Exception e)
			{
			System.out.println("Això no funciona perquè han d'haver al menys 2 jugadors");
			}
		}
}
