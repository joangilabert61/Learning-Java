package pla2Empleats;

class ClientP2 implements Saludar{
	
	String NOM_CLIENT;
	String EMAIL_CLIENT;
	String TIPO_CLIENT;
	
	ClientP2(String WNom, String WEmail, String WTipo) 
		{
		super();
		NOM_CLIENT = WNom;
		EMAIL_CLIENT = WEmail;
		TIPO_CLIENT = WTipo;
		Salutacio();
		}

	public void Salutacio() 
		{
		System.out.println("Bon dia. Soc el client " + NOM_CLIENT + " i això és el resultat de l'interface Salutació");
		}
	
	public void AReveure() {}
	
	public void Benvingut() {}
	
	
	public String getNom() {return NOM_CLIENT;}
	public void setNom(String WNom) {NOM_CLIENT = WNom;}
	
	public String getEmail() {return EMAIL_CLIENT;	}
	public void setEmail(String WEmail) {EMAIL_CLIENT = WEmail;	}
	
	public String getTipo() {return TIPO_CLIENT;}
	public void setTipo(String WTipo) {TIPO_CLIENT = WTipo;}
	
	//public void imprimeixClient() {System.out.println("Estic creant el client " + NOM_CLIENT + " amb el email " + EMAIL_CLIENT) + " del tipus " + TIPO_CLIENT + "." );}

	public void imprimeixClient(ClientP2 clientTreball) {System.out.println("Estic creant el client " + clientTreball.NOM_CLIENT + " amb el email " + clientTreball.EMAIL_CLIENT + " del tipus " + clientTreball.TIPO_CLIENT + "." );}
	
}

