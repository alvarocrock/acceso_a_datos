package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//abrir el servicio
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	Session sesion = sf.openSession();
    	try {
    	//abrir conexion
  
    	sesion.getTransaction().begin();
    	
    	prueba clase= new prueba(1,"juan");
    	prueba1A1 clase2= new prueba1A1("esto no es nada");
    	clase.setPrueba(clase2);
    	clase2.setPrueba(clase);
    	
    	
    	//guardar alumno
    	sesion.save(clase);
    	
    	sesion.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    	} finally {
	    	sesion.close();
	    	sf.close();
    	}
    	
	}

}
