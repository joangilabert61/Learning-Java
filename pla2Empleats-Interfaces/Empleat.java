package pla2Empleats;

class Empleat {
	
	private String NOM;
	private String DNI;
	private int SALARI;

	Empleat(String WNom, String WDni, int WSalari) 
		{
		super();
		NOM = WNom;
		DNI = WDni;
		SALARI = WSalari;
		}
		
	public String getNOM() {return NOM;	}
	public void setNOM(String WNom) {NOM = WNom;}
	
	public String getDNI() {return DNI;}
	public void setDNI(String WDni) {DNI = WDni;}
	
	public int getSALARI() {return SALARI;}
	public void setSALARI(int WSalari) {SALARI = WSalari;}
	
	public double getSALARINET() {return (SALARI * getIRPF());}
	
	private double getIRPF() 
		{
		if (SALARI < 3000)
			{return 0.85;}
		else
			{return 0.75;}
		}
	
	public void imprimeixSalariNet(Empleat empleatTreball) {System.out.println("El salari net de " + empleatTreball.NOM + " és de " + empleatTreball.getSALARINET() + " euros." );}
}

