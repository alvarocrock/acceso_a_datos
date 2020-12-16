package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	
	private static final String RUTA_FICHERO = "Alumnado_nuevo.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//abrir el servicio
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	Session sesion = sf.openSession();
    	try {
    	//abrir conexion
  
    	sesion.getTransaction().begin();
    	
    	//prueba clase= new prueba(1,"juan");
    	//prueba1A1 clase2= new prueba1A1("esto no es nada");
    	//clase.setPrueba(clase2);
    	//clase2.setPrueba(clase);
    	//profesor profesor=new profesor(7, "Sara", "Barrrera", "Salas");
    	//Set<alumno> alumnos=new HashSet();
    	//alumnos.add(new alumno(1,"pepe",profesor));
    	//alumnos.add(new alumno(2,"juan",profesor));
    	//alumnos.add(new alumno(3,"clara",profesor));
    	
    	//profesor.setAlumnos(alumnos);
    	
    	//sesion.save(profesor);
    	//guardar alumno
    	//sesion.save(clase2);
    	//sesion.save(clase);
    	
    	BufferedReader lector = null;
		String linea = null;
		ArrayList<SUPERusuario> superusuarios = new ArrayList();

		// Lectura de fichero e inserciones en tabla
		lector = new BufferedReader(new FileReader(RUTA_FICHERO));
		while ((linea = lector.readLine()) != null) {
			String[] campos = linea.split(",");
			String apellidos = campos[0];
			String nombre = campos[1];
			String user = getUser(nombre, apellidos);

			// Añadir superusuarios a la lista
			superusuarios.add(new SUPERusuario(nombre, apellidos, user));
		}
		// Cerrar lector
		lector.close();
		
		for (SUPERusuario superusuario : superusuarios) {
			sesion.save(superusuario);
		}

		sesion.getTransaction().commit();
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	} finally {
	    	sesion.close();
	    	sf.close();
    	}
    	
    		
    	
	}
	
	private static String getUser(String nombre, String apellidos) {
		return "2DAM" + nombre.charAt(1) + apellidos.charAt(0);
	}

}
