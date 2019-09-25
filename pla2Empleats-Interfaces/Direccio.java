package pla2Empleats;

public class Direccio extends Empleat implements Saludar{
	
	int STOCKOPTIONS;
	
	public void AReveure() {}
	public void Benvingut() {}
	public void Salutacio() {System.out.println("Bon dia. Soc el directiu " + getNOM() + " i això és el resultat de l'interface Salutació");}
	
	public Direccio(String WNom, String WDni, int WSalari, int WstockOptions) {
		super(WNom, WDni, WSalari);
		STOCKOPTIONS = WstockOptions;
		Salutacio();
	}

	public int getSTOCKOPTIONS() {return STOCKOPTIONS;}

	public void setSTOCKOPTIONS(int WStockOptions) {STOCKOPTIONS = WStockOptions;}

	public double getSALARINET() 
	{
		return  (super.getSALARINET() + (getSTOCKOPTIONS() * 0.1));			

	}

	
}
