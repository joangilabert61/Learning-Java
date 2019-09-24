package pla2Empleats;

import java.util.ArrayList;

public class program {

	public static void main(String[] args) 
	{
		ArrayList<Empleat> LlistaEmpleats = new ArrayList<Empleat>(); 
		
		// Empleat Joan, Monica, Emilio;
		
		Empleat Joan = new Empleat("Joan", "35038108T", 1000);
		LlistaEmpleats.add(Joan);
		
		Empleat Monica = new Empleat("Monica","01234567P", 10000);
		LlistaEmpleats.add(Monica);
		
		Empleat Emilio = new Empleat("Emilio","12345678T",23250);
		LlistaEmpleats.add(Emilio);
		
		for (int x=0;x<LlistaEmpleats.size();x++) 
		{
			LlistaEmpleats.get(x).imprimeixSalariNet(LlistaEmpleats.get(x));
		}

	}

}
