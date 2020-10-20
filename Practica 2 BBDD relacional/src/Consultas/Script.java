package Consultas;

import java.sql.DriverManager;
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
     * comportamiento que crea la conexión con la bbdd
     * @return
     */
	public java.sql.Connection conectar() {
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
		//tabla región
		crear_tabla("Region",TABLAREGION);
		//me falta crear la relaciones entre tablas
		crear_relaciones();
	}
	
	/**
	 * comportamiento para crear relaciones
	 */
	public void crear_relaciones() {
		//creamos las relaciones
		//relacion Nº matricula
		crear_relacion(FK_NMATRRICULA);
		//relación codigo asignatura
		crear_relacion(FK_CODASING);
		//relación cod prof
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

	      System.out.println("relación creada");

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
	
}
