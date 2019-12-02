package Pla7hibernate;


import java.sql.Connection;
import java.sql.DriverManager;

public class ProbarConexionBBDD {
	
		 public static boolean TestConnection() {
	
			 String bd="instituto";
			 String jdbcUrl = "jdbc:mysql://localhost:3306/"+bd+"?useSSL=false&serverTimezone=UTC";
			 String user = "root";
			 String pass = "Cifo2019";
			 try 
			 	{
				 System.out.println("Conectando: " + jdbcUrl);
				 Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
				 System.out.println("Todo bien. Circulen.");
				 myConn.close();
				 return true;
			 	}
			 catch (Exception exc) 
			 	{
				 exc.printStackTrace();
				 return false;

			 	}
	}

}
