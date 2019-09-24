package pla2Empleats;

public class Gerent extends Empleat {
	
		String DEPARTAMENT;
		int DIETAS;
		
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
		}

		public double getSALARINET() 
		{
			return  (super.getSALARINET() + getDIETAS());			

		}

}
