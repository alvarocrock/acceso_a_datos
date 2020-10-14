import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.jdi.connect.spi.Connection;

public class Conexion {
	 private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/puebabbdd?allowPublicKeyRetrieval=true&useSSL=false";
	    private static final String USUARIO = "usuario";
	    private static final String CLAVE = "usuario";
	   
	    public static java.sql.Connection conectar() {
	    	java.sql.Connection conexion = null;

	        
	        try {
	            Class.forName(CONTROLADOR);
	            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
	            System.out.println("Conexión OK");

	        } catch (ClassNotFoundException e) {
	            System.out.println("Error al cargar el controlador");
	            e.printStackTrace();

	        } catch (SQLException e) {
	            System.out.println("Error en la conexión");
	            e.printStackTrace();
	        }
	        
	        return conexion;
	    }
	    
	    public static void consulta(String nombretabla) {
	    	Conexion conexion = new Conexion();
	        java.sql.Connection cn = null;
	        Statement stm = null;
	        ResultSet rs = null;
	        
	        try {
	            cn = conexion.conectar();
	            stm =  (Statement) cn.createStatement();
	            rs = stm.executeQuery("SELECT * FROM "+ nombretabla);
	            
	            while (rs.next()) {
	                int idUsuario = rs.getInt(1);
	                String usuario = rs.getString(2);
	                String clave = rs.getString(3);
	                escribirfichero(idUsuario + " - " + usuario + " - " + clave,nombretabla);
	                //System.out.println(idUsuario + " - " + usuario + " - " + clave);
	            }
	            System.out.print("escritura correcta");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        } finally {
	        	
	            try {
	                if (rs!= null) {
	                    rs.close();
	                }
	                
	                if (stm != null) {
	                    stm.close();
	                }
	                
	                if (cn != null) {
	                    cn.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        
	    }
	    	
	    public static void escribirfichero(String linea, String nombretabla) {
	    	FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(nombretabla+"_fichero.txt",true);
	            pw = new PrintWriter(fichero);
	            pw.println(linea + "/n");
	        
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	           
	        }
	        
	    }
	    
	    public static void main(String[] args) {
	    	//conectar();
	    	consulta("usuarios");
	    }
}
