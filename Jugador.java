package pla2JocsDeCartes;

import java.util.ArrayList;

public class Jugador 
{
	private String NOMJUGADOR;
	private ArrayList<Carta> CARTESJUGADOR = new ArrayList<Carta>();   
	
//	public Jugador(String Wnomjugador, ArrayList<Carta> Wcartesjugador) 
//		{
//		NOMJUGADOR = Wnomjugador;
//		CARTESJUGADOR = Wcartesjugador; 
//		}
	public Jugador(String Wnomjugador) 
		{
		NOMJUGADOR = Wnomjugador;
		CARTESJUGADOR.clear(); 
		}
	
	public String getNOMJUGADOR() {return NOMJUGADOR;}
	public void setNOMJUGADOR(String WNomjugador) {	NOMJUGADOR = WNomjugador;}
	
	public ArrayList<Carta> getCARTESJUGADOR() {return CARTESJUGADOR;}
	public void setCARTESJUGADOR(ArrayList<Carta> WCartesjugador) {CARTESJUGADOR = WCartesjugador;}
	
	public void darCarta(Carta WCartadonada) {CARTESJUGADOR.add(WCartadonada);}
	
	public Carta retirarCarta(int index) 
		{
		Carta wCartaDonada=CARTESJUGADOR.get(index);
		CARTESJUGADOR.remove(index);
		return wCartaDonada;
		}
	
	public String juego() 
		{
		String wJuego="[";
		for (int x=0;x<CARTESJUGADOR.size();x++)
			{
			wJuego=wJuego + CARTESJUGADOR.get(x);
			
			if (x<CARTESJUGADOR.size()-1) {wJuego=wJuego+", ";}
			}
		wJuego=wJuego+"]";
		return wJuego;
		}

}
