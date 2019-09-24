package pla2Empleats;

public class Direccio extends Empleat {
	
	int STOCKOPTIONS;
	
	public Direccio(String WNom, String WDni, int WSalari, int WstockOptions) {
		super(WNom, WDni, WSalari);
		STOCKOPTIONS = WstockOptions;
	}

	public int getSTOCKOPTIONS() {return STOCKOPTIONS;}

	public void setSTOCKOPTIONS(int WStockOptions) {STOCKOPTIONS = WStockOptions;}

	public double getSALARINET() 
	{
		return  (super.getSALARINET() + (getSTOCKOPTIONS() * 0.1));			

	}

	
}
