import java.util.Scanner;

public class pla1Ifs {

	public static void main(String[] args) 
	{
		String cadena1="";
		String cadena2="";
		int alsada = 0;
		int edat = 0;
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quina �s la teva al�ada (en cms)?:");
		cadena1=entrada.nextLine();
		
		if (esNumeroSencer(cadena1))
			{
			alsada=Integer.parseInt(cadena1);
			System.out.println("Al�ada: " + alsada);
			}
		else
			{
			System.out.println("La teva al�ada " + cadena1 + " no �s un nombre sencer v�lid.");
			alsada=-10;
			}
				
		System.out.print("Quants anys tens? (ja fets, no t'hi possis de m�s!):");
		cadena2=entrada.nextLine();
				
		if (esNumeroSencer(cadena2))
			{
			edat=Integer.parseInt(cadena2);
			System.out.println("Edat: " + edat);
			}
		else
			{
			System.out.println("La teva edat " + cadena2 + " no �s un nombre sencer v�lid.");
			edat=-10;
			}

		if (alsada < 1 || edat < 1)
			{
			System.out.println("Les dades que ens has donat no s�n correctes. No pots entrar.");
			}
		else if (alsada >= 140 || edat > 16 )
			{
			System.out.println("Pots entrar. Diverteix-te!");
			}
		else
		{
			System.out.println("Per vetllar per la teva seguretat, no pots entrar al reciente. Torna m�s endavant.");
		
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
