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

public class bbddMod_Alu {

		//----------------------------------------------------------------------------------------------------------------
		// Crear n registros
		//----------------------------------------------------------------------------------------------------------------
			
		public static Mod_Alu crear(Modulos wModulo, Alumnos wAlumno) {       
				
				// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
				
				Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mod_Alu.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
				// Crear la factoría de sesiones
				
				SessionFactory factory = configuration.buildSessionFactory(builder.build());
					
				
				// Crear la sesión
				
				Session session = factory.getCurrentSession();
				
				try {
				
						// Iniciar transacción
				
						session.beginTransaction();
				
						// Creamos n Mod_Alu
				
						Mod_Alu cat = new Mod_Alu(wModulo, wAlumno);
						
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
			
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mod_Alu.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			// Crear la factoría de sesiones
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			// Crear la sesión
			
			Session session = factory.getCurrentSession();
			
			try {
			
					// Iniciar transacción
			
					session.beginTransaction();
			
					// consulta nombre de una categoria
			
					Mod_Alu cat = session.get(Mod_Alu.class,wId);
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
			
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mod_Alu.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			// Crear la factoría de sesiones
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			// Crear la sesión
			
			Session session = factory.getCurrentSession();
			
			try {
			
					// Iniciar transacción
			
					session.beginTransaction();
			
					// consulta Mod_Alu por parte del nombre
			
					@SuppressWarnings("unchecked")
					List<Mod_Alu> lista = session.createQuery("from Mod_Alu c where c.nombre like '%\" + wNombre + \"%' ").getResultList();
					
					for (Mod_Alu c : lista) {System.out.println(c);}

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
		public static void modificar(int wId, Modulos wModulo, Alumnos wAlumno) {       
			
			// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
			
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mod_Alu.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			// Crear la factoría de sesiones
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			// Crear la sesión
			
			Session session = factory.getCurrentSession();
			
			try {
			
					// Iniciar transacción
			
					session.beginTransaction();
			
					// consukta nombre de una categoria
			
					Mod_Alu cat = session.get(Mod_Alu.class,wId);
					System.out.println(cat.getModulos() + " --- " + cat.getAlumnos());

					cat.setModulos(wModulo);
					cat.setAlumnos(wAlumno);
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
			
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mod_Alu.class) .addAnnotatedClass(Alumnos.class) .addAnnotatedClass(Profesores.class) .addAnnotatedClass(Modulos.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			// Crear la factoría de sesiones
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			// Crear la sesión
			
			Session session = factory.getCurrentSession();
			
			try {
			
					// Iniciar transacción
			
					session.beginTransaction();
			
					// consukta nombre de una categoria
			
					Mod_Alu cat = session.get(Mod_Alu.class,wId);
					System.out.println(cat.getModulos()+ " --- " + cat.getAlumnos());

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
