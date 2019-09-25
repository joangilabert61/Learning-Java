package pla2Empleats;

public class Gerent extends Empleat implements Saludar{
	
		String DEPARTAMENT;
		int DIETAS;
		
		public void AReveure() {}
		public void Benvingut() {}
		public void Salutacio() {System.out.println("Bon dia. Soc el gerent " + getNOM() + " i això és el resultat de l'interface Salutació");}
		
		
		public String getDEPARTAMENT() {
			return DEPARTAMENT;
		}

		public void setDEPARTAMENT(String WDepartament) {
			DEPARTAMENT = WDepartament;
		}

		public int getDIETAS() {
			return DIETAS;
		}

		public void setDIETAS(int WDietas) {
			DIETAS = WDietas;
		}

		public Gerent(String WNom, String WDni, int WSalari, String WDepartament, int WDietas) {
			super(WNom, WDni, WSalari);
			DEPARTAMENT = WDepartament;
			DIETAS = WDietas;
			Salutacio();
		}

		public double getSALARINET() 
		{
			return  (super.getSALARINET() + getDIETAS());			

		}

}
