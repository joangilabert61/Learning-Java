package Pla7hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entidades.Alumnos;
import entidades.Modulos;
import entidades.Profesores;

public class bbddAlumnos {

	public static entidades.Alumnos crear(String wNombre, String wEmail, Modulos wModulo) {       
		
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
		
		// Crear la sesi�n
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacci�n
		
				session.beginTransaction();
		
				// Creamos alumnos
		
				Alumnos cat = new Alumnos(wNombre, wEmail);
				
				// Guardar
				session.save(cat);
			
				cat.addModulos(wModulo);
				
				// commit de la transacci�n
		
				session.getTransaction().commit();
				return cat;
			} 
		finally 
			{
				factory.close();
			}
		}
	
	public static void consultar(int wId) {       
		
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesi�n
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacci�n
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Alumnos cat = session.get(Alumnos.class,wId);
				System.out.println(cat.toString());
	
		
				// commit de la transacci�n
		
				// session.getTransaction().commit();
			} 
		finally 
			{
				factory.close();
			}
		}
	public static void lista(String wNombre) {       
		
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
		
		// Crear la sesi�n
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacci�n
		
				session.beginTransaction();
		
				// consulta alumnos por parte del nombre
		
				@SuppressWarnings("unchecked")
				List<Alumnos> lista = session.createQuery("from Alumnos c where c.nombre like '%" + wNombre + "%' ").getResultList();
				
				for (Alumnos c : lista) {System.out.println(c);}
	
				// commit de la transacci�n
		
				session.getTransaction().commit();
			} 
		finally 
			{
				factory.close();
			}
		}
	public static void modificar(int wId, String wNombre, String wEmail) {       
		
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesi�n
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacci�n
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Alumnos cat = session.get(Alumnos.class,wId);
				System.out.println(cat.getNombre() + " --- " + cat.getEmail());
	
				cat.setNombre(wNombre);
				cat.setEmail(wEmail);
				session.save(cat);
		
				// commit de la transacci�n
		
				session.getTransaction().commit();
			} 
		finally 
			{
				factory.close();
			}
		}
	
	public static void eliminar(int wId) {       
		
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesi�n
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacci�n
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Alumnos cat = session.get(Alumnos.class,wId);
				System.out.println(cat.getNombre()+ " --- " + cat.getEmail());
	
				session.delete(cat);

		
				// commit de la transacci�n
		
				session.getTransaction().commit();
			} 
		finally 
			{
				factory.close();
			}
		}
	
}
