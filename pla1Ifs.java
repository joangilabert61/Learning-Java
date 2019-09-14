import java.util.Scanner;

public class pla1Ifs {

	public static void main(String[] args) 
	{
		String cadena1="";
		String cadena2="";
		int alsada = 0;
		int edat = 0;
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quina és la teva alçada (en cms)?:");
		cadena1=entrada.nextLine();
		
		if (esNumeroSencer(cadena1))
			{
			alsada=Integer.parseInt(cadena1);
			System.out.println("Alçada: " + alsada);
			}
		else
			{
			System.out.println("La teva alçada " + cadena1 + " no és un nombre sencer vàlid.");
			alsada=-10;
			}
				
		System.out.print("Quants anys tens? (ja fets, no t'hi possis de més!):");
		cadena2=entrada.nextLine();
				
		if (esNumeroSencer(cadena2))
			{
			edat=Integer.parseInt(cadena2);
			System.out.println("Edat: " + edat);
			}
		else
			{
			System.out.println("La teva edat " + cadena2 + " no és un nombre sencer vàlid.");
			edat=-10;
			}

		if (alsada < 1 || edat < 1)
			{
			System.out.println("Les dades que ens has donat no són correctes. No pots entrar.");
			}
		else if (alsada >= 140 || edat > 16 )
			{
			System.out.println("Pots entrar. Diverteix-te!");
			}
		else
		{
			System.out.println("Per vetllar per la teva seguretat, no pots entrar al reciente. Torna més endavant.");
		
		}
			
		
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
