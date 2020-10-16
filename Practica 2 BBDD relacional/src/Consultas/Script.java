package Consultas;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Constantes.ConsultasSQL;

import java.sql.Connection;

/**
 * Esta clase exttiende de consultas sql que contiene las contantes de las busquedas
 * @author alvar
 *
 */
public class Script extends ConsultasSQL{
	//estado
	private final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/practica2_a_datos_java?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USUARIO = "usuario";
    private final String CLAVE = "usuario";
    
    
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
	public void CrearTablas() {
		
		//crear tabla usuario
		CrearTabla("Usuario",TABLAUSUARIO);
		//crear tabla asignatura
		CrearTabla("Asignatura",TABLAASIGNATURA);
		//Crear tabla profesor
		CrearTabla("Profesor",TABLAPROFESOR);
		//crear tabla recibe
		CrearTabla("Recibe",TABLARECIBE);
		//tabla epleados
		CrearTabla("Empleado",TABLAEMPLEADO);
		//taabla localidad
		CrearTabla("Localidad",TABLALOCALIDAD);
		//tabla provincia
		CrearTabla("Provincia",TABLAPROVINCIA);
		//tabla región
		CrearTabla("Region",TABLAREGION);
		//me falta crear la relaciones entre tablas
		CrearRelaciones();
	}
	
	/**
	 * comportamiento para crear relaciones
	 */
	public void CrearRelaciones() {
		//creamos las relaciones
		//relacion Nº matricula
		CrearRelacion(FK_NMATRRICULA);
		//relación codigo asignatura
		CrearRelacion(FK_CODASING);
		//relación cod prof
		CrearRelacion(FK_IDPROF);
		//relacion cod localidad
		CrearRelacion(FK_CODLOCALIDAD);
		//relacion codprovincia
		CrearRelacion(FK_CODPROVINCIA);
		//relacion codregion
		CrearRelacion(FK_CODREGION);
	}
	
	
	/**
	 * Crea una tabla  pasandole una consulta y el nombre de la tabla
	 * @param nombretabla
	 * @param miconsulta
	 */
	protected void CrearTabla(String nombretabla,String miconsulta) {
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
	protected void CrearRelacion(String miconsulta) {
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
