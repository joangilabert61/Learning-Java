package pla2Empleats;

public class Administracio extends Empleat {
	
	String Seccio;


	public Administracio(String WNom, String WDni, int WSalari, String seccio) {
		super(WNom, WDni, WSalari);
		Seccio = seccio;
	}

	public String getSeccio() {
		return Seccio;
	}

	public void setSeccio(String WSeccio) {
		Seccio = WSeccio;
	}

}
