package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class controlador {
	
	//static final nombreConstante = valor;
	private static final String fichero= "src/fichero.txt";
	ArrayList<String> lista;
	
	public controlador() {
		lista= new ArrayList();
	}
	
	/**
	 * comportamiento que retorna una conexión
	 * @return
	 */
	public java.sql.Connection conectar() {
    	java.sql.Connection conexion = null;

        
        try {
            Class.forName(contantes.CONTROLADOR);
            conexion = DriverManager.getConnection(contantes.URL, contantes.USUARIO, contantes.CLAVE);
            //System.out.println("Conexiï¿½n OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexiï¿½n");
            e.printStackTrace();
        }
        
        return conexion;
    }
	
	/**
	 * compoprtamiento que crea las tablas de la bbddd
	 */
	public void creartablas() {
		
		//crear tabla usuario
		crear_tabla("Usuario",contantes.TABLAUSUARIO);
		//crear tabla asignatura
		crear_tabla("Asignatura",contantes.TABLAASIGNATURA);
		//Crear tabla profesor
		crear_tabla("Profesor",contantes.TABLAPROFESOR);
		//crear tabla recibe
		crear_tabla("Recibe",contantes.TABLARECIBE);
		//me falta crear la relaciones entre tablas
		crear_relaciones();
	}
	
	/**
	 * comportamiento que crea las relaciones
	 */
	public void crear_relaciones() {
		//creamos las relaciones
		//relacion Nï¿½ matricula
		crear_relacion(contantes.FK_NMATRRICULA);
		//relaciï¿½n codigo asignatura
		crear_relacion(contantes.FK_CODASING);
		//relaciï¿½n cod prof
		crear_relacion(contantes.FK_IDPROF);
	}

	/**
	 * Crea una tabla  pasandole una consulta y el nombre de la tabla
	 * @param nombretabla
	 * @param miconsulta
	 */
	protected void crear_tabla(String nombretabla,String miconsulta) {
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      stmt.executeUpdate(miconsulta);

	      System.out.println("Tabla "+ nombretabla+ " creada");
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	/**
	 * crea una relacion pasandole una consulta
	 * @param miconsulta
	 */
	protected void crear_relacion(String miconsulta) {
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      stmt.executeUpdate(miconsulta);

	      System.out.println("relacion creada");

	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	/**
	 * comportamiento que añade linea de un fichero a una array list
	 */
	public void add_data() {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (fichero);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	            lista.add(linea);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	
	/**
	 * inserta campos de la array list
	 */
	public void insert() {
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      conn.setAutoCommit(false);
	      stmt = (Statement) conn.createStatement();
	      String consulta="";
	      String tabla="";
	      String idprof = "";
	      int numero=0;
	      for (int cont=0;cont<lista.size();cont++) {
	    	  String [] split = lista.get(cont).split(";");
	    	  tabla=split[0];
	    	  if (numero<=4) {
	    	  if (tabla.equals("Profesor")) {
	    		  consulta="INSERT INTO "+ split[0] +" (nif_p,nombre,especialidad,telefono) "
	    	       + "VALUES ('"+ split[1]+"','"+ split[2] +"','"+ split[3]+"','"+ split[4] +"');";
	    		  stmt.addBatch(consulta);
	    		 idprof="13";
	    	  } else if (tabla.equals("Asignatura")) {
	    		  if (idprof!="0") {
	    			  //la fk siempre es 13, cambiarlo
	    		  consulta="INSERT INTO " +split[0] + "(CodAsignatura, Nombre,IdProfesor) VALUES ('"+split[1] +"','"+split[2] +"','2');";
	    		  stmt.addBatch(consulta);
	    		  }
	    	  }
	    	  numero++;
	    	  } else {
	    		  numero=0;
	    		  int[] count = stmt.executeBatch();
	    		  conn.commit();
	    		  stmt.clearBatch();
	    		  //System.out.println("datos añadidos");
	    		  
	    	  }
	      }
	      
	  
	      conn.commit();

	      //System.out.println("relacion creada");

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	System.out.println("error al introducir datos");
	    	try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}

	
}

