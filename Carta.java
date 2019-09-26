package pla2JocsDeCartes;

public class Carta {

	private String PAL;
	private String NOM;
	private int VALOR;
	
	public Carta(String Wpal, String Wnom, int Wvalor) 
		{	
		PAL = Wpal;
		NOM = Wnom;
		VALOR = Wvalor;
		}
	
	public String getPal() {return PAL;}
	public void setPal(String Wpal) {PAL = Wpal;}
	
	public String getNom() {return NOM;}
	public void setNom(String Wnom) {NOM = Wnom;}
	
	public int getValor() {return VALOR;}
	public void setValor(int Wvalor) {VALOR = Wvalor;}
	
	public String toString ()
		{
        String Wdescripcio= NOM + " de " + PAL;
        return Wdescripcio;
		}

}
