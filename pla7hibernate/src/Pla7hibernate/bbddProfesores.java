package Pla7hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entidades.Alumnos;
import entidades.Modulos;
import entidades.Profesores;

public class bbddProfesores {
//----------------------------------------------------------------------------------------------------------------
// Crear n registros
//----------------------------------------------------------------------------------------------------------------
	
public static entidades.Profesores crear(String wNombre, String wDni, String wEmail) {       
		
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
		
		// Crear la sesión
		
		Session session = factory.getCurrentSession();
		
		try {
		
				
			
				// Iniciar transacción
		
				session.beginTransaction();
		
				// Creamos n profesores
				Profesores cat = new Profesores(wNombre, wDni, wEmail);
				// Guardar
				session.save(cat);
						
				// commit de la transacción
				session.getTransaction().commit();
				return cat;
			} 
		finally 
			{
				factory.close();
			}
		}
//----------------------------------------------------------------------------------------------------------------
//Consultar 1 registro
//----------------------------------------------------------------------------------------------------------------
public static void consultar(int wId) {       
	
	// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	
	// Crear la factoría de sesiones
	
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	// Crear la sesión
	
	Session session = factory.getCurrentSession();
	
	try {
	
			// Iniciar transacción
	
			session.beginTransaction();
	
			// consukta nombre de una categoria
	
			Profesores cat = session.get(Profesores.class,wId);
			System.out.println(cat.toString());

	
			// commit de la transacción
	
			// session.getTransaction().commit();
		} 
	finally 
		{
			factory.close();
		}
	}
//----------------------------------------------------------------------------------------------------------------
//Listar registros seleccionados por una parte de la descripcion
//----------------------------------------------------------------------------------------------------------------
public static void lista(String wNombre) {       
	
	// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	
	// Crear la factoría de sesiones
	
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	// Crear la sesión
	
	Session session = factory.getCurrentSession();
	
	try {
	
			// Iniciar transacción
	
			session.beginTransaction();
	
			// consulta Profesores por parte del nombre
	
			@SuppressWarnings("unchecked")
			List<Profesores> lista = session.createQuery("from Profesores c where c.nombre like '%" + wNombre + "%' ").getResultList();
			
			for (Profesores c : lista) {System.out.println(c);}

			// commit de la transacción
	
			session.getTransaction().commit();
		} 
	finally 
		{
			factory.close();
		}
	}
//----------------------------------------------------------------------------------------------------------------
//Modificar 1 registro
//----------------------------------------------------------------------------------------------------------------
public static void modificar(int wId, String wNombre, String wDni,String wEmail) {       
	
	// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	
	// Crear la factoría de sesiones
	
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	// Crear la sesión
	
	Session session = factory.getCurrentSession();
	
	try {
	
			// Iniciar transacción
	
			session.beginTransaction();
	
			// consukta nombre de una categoria
	
			Profesores cat = session.get(Profesores.class,wId);
			System.out.println(cat.getNombre() + " --- " + cat.getEmail());

			cat.setNombre(wNombre);
			cat.setEmail(wEmail);
			cat.setDni(wDni);
			session.save(cat);
	
			// commit de la transacción
	
			session.getTransaction().commit();
		} 
	finally 
		{
			factory.close();
		}
	}
//----------------------------------------------------------------------------------------------------------------
//Eliminar 1 registro
//----------------------------------------------------------------------------------------------------------------
public static void eliminar(int wId) {       
	
	// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	
	// Crear la factoría de sesiones
	
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	// Crear la sesión
	
	Session session = factory.getCurrentSession();
	
	try {
	
			// Iniciar transacción
	
			session.beginTransaction();
	
			// consukta nombre de una categoria
	
			Profesores cat = session.get(Profesores.class,wId);
			System.out.println(cat.getNombre()+ " --- " + cat.getEmail());

			session.delete(cat);

	
			// commit de la transacción
	
			session.getTransaction().commit();
		} 
	finally 
		{
			factory.close();
		}
	}
}
