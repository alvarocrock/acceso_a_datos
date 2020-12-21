package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Main.Tipos.TipoCelda;

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
    	
    	byte array[]={(byte)0x45,(byte)0xF5,(byte)0x3A,(byte)0x67,(byte)0xFF};
    	Date date=new Date();
    	
    	Tipos tipo= new Tipos();
    	tipo.setInte(1);
    	  tipo.setLong1(12);
    	  tipo.setShort1((short)13);
    	  tipo.setFloat1(14.1F);
    	  tipo.setDouble1(15.2);
    	 tipo.setCharacter1('W');
    	 tipo.setByte1((byte)16);
    	 tipo.setBoolean1(true);
    	 tipo.setYesno1(true);
    	 tipo.setTruefalse1(true);
    	 tipo.setStri("Hola mundo");
    	 tipo.setDateDate(date);
    	 tipo.setDateTime(date);
    	 tipo.setDateTimestamp(date);
    	 tipo.setTexto("texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo");
    	 tipo.setBinario(array);
    	 tipo.setBigDecimal(new BigDecimal("0.3"));
    	 tipo.setBigInteger(new BigInteger("5345345324532"));
    	 tipo.setTipo(TipoCelda.Dos);
    	 
    	 sesion.save(tipo);
    	 sesion.getTransaction().commit();
    	 sesion.close();

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    		
    	
	}
	
	private static String getUser(String nombre, String apellidos) {
		return "2DAM" + nombre.charAt(1) + apellidos.charAt(0);
	}

}
