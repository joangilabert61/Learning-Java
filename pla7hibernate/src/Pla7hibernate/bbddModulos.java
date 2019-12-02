package Pla7hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entidades.Alumnos;
import entidades.Mod_Alu;
import entidades.Modulos;
import entidades.Profesores;

public class bbddModulos {

	//----------------------------------------------------------------------------------------------------------------
	// Crear n registros
	//----------------------------------------------------------------------------------------------------------------
		
	public static entidades.Modulos crear(Profesores wProfesor, String wNombre) {       
			
			// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
			
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modulos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Alumnos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			// Crear la factoría de sesiones
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
				
			
			// Crear la sesión
			
			Session session = factory.getCurrentSession();
			
			try {
			
					// Iniciar transacción
			
					session.beginTransaction();
			
					// Creamos  Modulos
			
					Modulos cat = new Modulos(wProfesor, wNombre);
					
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
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modulos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Mod_Alu.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacción
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Modulos cat = session.get(Modulos.class,wId);
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
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modulos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacción
		
				session.beginTransaction();
		
				// consulta Modulos por parte del nombre
		
				@SuppressWarnings("unchecked")
				List<Modulos> lista = session.createQuery("from Modulos c where c.nombre like '%" + wNombre + "%' ").getResultList();
				
				for (Modulos c : lista) {System.out.println(c);}

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
	public static void modificar(int wId, Profesores wProfesor, String wNombre) {       
		
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modulos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacción
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Modulos cat = session.get(Modulos.class,wId);
				System.out.println(cat.getProfesores() + " --- " + cat.getNombre());

				cat.setNombre(wNombre);
				cat.setProfesores(wProfesor);
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
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modulos.class) .addAnnotatedClass(Profesores.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		
		Session session = factory.getCurrentSession();
		
		try {
		
				// Iniciar transacción
		
				session.beginTransaction();
		
				// consukta nombre de una categoria
		
				Modulos cat = session.get(Modulos.class,wId);
				System.out.println(cat.getProfesores()+ " --- " + cat.getNombre());

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
