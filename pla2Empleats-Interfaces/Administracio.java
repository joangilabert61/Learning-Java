package pla2Empleats;

public class Administracio extends Empleat implements Saludar{
	
	String Seccio;

	public void AReveure() {}
	public void Benvingut() {}
	public void Salutacio() {System.out.println("Bon dia. Soc l'Administratiu " + getNOM() + " i això és el resultat de l'interface Salutació");}
	

	public Administracio(String WNom, String WDni, int WSalari, String seccio) {
		super(WNom, WDni, WSalari);
		Seccio = seccio;
		Salutacio();
	}

	public String getSeccio() {
		return Seccio;
	}

	public void setSeccio(String WSeccio) {
		Seccio = WSeccio;
	}

}
