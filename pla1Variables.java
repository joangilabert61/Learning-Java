import java.util.Scanner;

public class pla1Variables {
	
	public static void main(String args[]) 
	{
		String cadena1="";
		String cadena2="";
		int nombre1 = 0;
		int nombre2 = 0;
		int suma = 0;
		int producte = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introdueix el primer nombre:");
		cadena1=entrada.nextLine();
		
		if (esNumeroSencer(cadena1))
			{
			nombre1=Integer.parseInt(cadena1);
			System.out.println("El primer valor és " + nombre1);
			}
		else
			{
			System.out.println("El valor " + cadena1 + " no és un nombre sencer vàlid. Pendrà el valor 1 per defecte.");
			nombre1=1;
			}
				
		System.out.print("Introdueix el segon nombre:");
		cadena2=entrada.nextLine();
				
		if (esNumeroSencer(cadena2))
			{
			nombre2=Integer.parseInt(cadena2);
			System.out.println("El segon valor és " + nombre2);
			}
		else
			{
			System.out.println("El valor " + cadena2 + " no és un nombre sencer vàlid. Pendrà el valor -1 per defecte.");
			nombre2=-1;
			}

		suma = nombre1 + nombre2;
		producte = nombre1 * nombre2;
		
		System.out.println("La suma de " + nombre1 + " + " + nombre2 + " és " + suma);
		System.out.println("El producte de " + nombre1 + " * " + nombre2 + " és " + producte);

		
	}

	private static boolean esNumeroSencer(String cadena)
	{
		try 
		{
			Integer.parseInt(cadena);
			return true;
		} 
		catch (NumberFormatException nfe)
		{
			return false;
		}
	}
		
}
