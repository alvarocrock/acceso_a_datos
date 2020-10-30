package Consultas;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Constantes.ConstantesDeUsuario;
import Constantes.ConsultasSQL;

import java.sql.Connection;

/**
 * Esta clase exttiende de consultas sql que contiene las contantes de las busquedas
 * @author alvar
 *
 */
public class Script extends ConsultasSQL implements ConstantesDeUsuario{
	//estado
	//esta en constantes
    
    
    public Script() {
		
	}
	
    /**
     * comportamiento que crea la conexiï¿½n con la bbdd
     * @return
     */
	public java.sql.Connection conectar() {
    	java.sql.Connection conexion = null;

        
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
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
	 * comportamiento que llama a crear las tablas y sis relaciones
	 */
	public void creartablas() {
		
		//crear tabla usuario
		crear_tabla("Usuario",TABLAUSUARIO);
		//crear tabla asignatura
		crear_tabla("Asignatura",TABLAASIGNATURA);
		//Crear tabla profesor
		crear_tabla("Profesor",TABLAPROFESOR);
		//crear tabla recibe
		crear_tabla("Recibe",TABLARECIBE);
		//tabla epleados
		crear_tabla("Empleado",TABLAEMPLEADO);
		//taabla localidad
		crear_tabla("Localidad",TABLALOCALIDAD);
		//tabla provincia
		crear_tabla("Provincia",TABLAPROVINCIA);
		//tabla regiï¿½n
		crear_tabla("Region",TABLAREGION);
		//me falta crear la relaciones entre tablas
		crear_relaciones();
	}
	
	/**
	 * comportamiento para crear relaciones
	 */
	public void crear_relaciones() {
		//creamos las relaciones
		//relacion Nï¿½ matricula
		crear_relacion(FK_NMATRRICULA);
		//relaciï¿½n codigo asignatura
		crear_relacion(FK_CODASING);
		//relaciï¿½n cod prof
		crear_relacion(FK_IDPROF);
		//relacion cod localidad
		crear_relacion(FK_CODLOCALIDAD);
		//relacion codprovincia
		crear_relacion(FK_CODPROVINCIA);
		//relacion codregion
		crear_relacion(FK_CODREGION);
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
	 * Comportamiento que crea relaciones entre tablas
	 * @param miconsulta
	 */
	protected void crear_relacion(String miconsulta) {
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      stmt.executeUpdate(miconsulta);

	      System.out.println("relaciï¿½n creada");

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
	 * agrega datos a tablas pasandole una consulta
	 * @param tabla
	 * @param miconsulta
	 */
	public void modificar_datos(String campo,String tabla,String nuevovalor,String campoprimario,String valorpk) {
		Connection conne = null;
	    Statement stmte = null;

	    try {

	      conne = conectar();
	      stmte = (Statement) conne.createStatement();
	      String consulta = "UPDATE "+tabla+" SET "+campo+"="+"'"+nuevovalor+"'"+" where "+campoprimario+" = "+valorpk+";";
	      
	      stmte.executeUpdate(consulta);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        // Close connection
	        if (stmte != null) {
	          stmte.close();
	        }
	        if (conne != null) {
	          conne.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	/**
	 * proceso para aï¿½adir a profesores un nuevo campo pasandole parametros
	 * @param ID
	 * @param NIF
	 * @param nombre
	 * @param especialidad
	 * @param Telefono
	 */
	public void añadir_datos_prof(String ID,String NIF,String nombre,String especialidad,String Telefono) {
		Connection conne = null;
	    Statement stmte = null;

	    try {

	      conne = conectar();
	      stmte = (Statement) conne.createStatement();
	      //INSERT INTO usuarios (nombre, apellidos) VALUES ('Juan','Garcia Pï¿½rez');
	      String consulta = "INSERT INTO profesor (IdProfesor,NIF_P,Nombre,Especialidad,Telefono) VALUES('"+ID+"','"+NIF+"','"+nombre+"','"+especialidad+"','"+Telefono+"');" ;
	      
	      stmte.executeUpdate(consulta);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        // Close connection
	        if (stmte != null) {
	          stmte.close();
	        }
	        if (conne != null) {
	          conne.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	/**
	 * proceso para eliminar una tabla pasandole el nombre d la tabla a borrar
	 * @param tabla
	 */
	public void eliminar_tabla(String tabla) {
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();
	      String consulta="DROP TABLE IF EXISTS "+tabla+";";

	      stmt.executeUpdate(consulta);

	      System.out.println("tabla "+tabla+" eliminada");

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
	 * comportamiento que borra la bbdd
	 */
	public void eliminarbbdd() {
		eliminar_tabla("recibe");
		eliminar_tabla("asignatura");
		eliminar_tabla("profesor");
		eliminar_tabla("alumno");
		
		eliminar_tabla("empleado");//ok
		eliminar_tabla("localidad");
		eliminar_tabla("provincia");
		eliminar_tabla("region");
		
		
	}
	
    
	
}
