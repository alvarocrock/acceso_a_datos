package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Flow.Processor;

import com.mysql.jdbc.Statement;

import Consultas.Script;
import clases.Profesor;

public class ControladorBBDD {
	
	static Script miscript;
	Connection cn;
    Statement stm;
    ResultSet rs;
    Profesor miprofe;
	
    /**
     * contructor controlador bbdd
     */
	public ControladorBBDD() {
		miscript = new Script();
		cn=null;
		stm=null;
		rs=null;
		miprofe=null;
	}
	
	/**
     * comportamineto que realiza una consulta y retorna un objeto de tipo profesor
     * @param nombretabla
     */
	public void consultaprofe(String nombretabla) {
		//Connection conn = null;
        
        try {
            cn = miscript.conectar();
            stm = (Statement) cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM "+ nombretabla);
            
            //miprofe=siguiente();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
        	
        }
        

    }
	
	/**
	 * cambia el puntero a la siguiente linea
	 * @return
	 */
	public Profesor siguiente() {
		try {
			if (rs.next()) {
			//rs.next();
			crear_profesor();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (miprofe!=null) {
			return miprofe;
		} else {
			return null;
		}
	}
	
	/**
	 * cambia el puntero a la primera linea
	 * @return
	 */
	public Profesor primero() {
		try {
			if(rs.first()) {
			crear_profesor();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (miprofe!=null) {
			return miprofe;
		} else {
			return null;
		}
	}
	
	/**
	 * cambia el puntero al ultimo registro
	 * @return
	 */
	public Profesor ultimo() {
		try {
			if (rs.last()) {
			crear_profesor();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (miprofe!=null) {
			return miprofe;
		} else {
			return null;
		}
	}
	
	
	/**
	 *cambia el puntero al registro anterior
	 * @return
	 */
	public Profesor anterior() {
		try {
			if (rs.previous()) {
			//rs.previous();
			crear_profesor();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (miprofe!=null) {
			return miprofe;
		} else {
			return null;
		}
	}
	
	/**
	 * proceso para crear un objeto de tipo profesor
	 */
	public void crear_profesor() {
		try {
			String id = rs.getString(1); 
    	    String nifp =rs.getString(2);
          	String nombre = rs.getString(3);
          	String especialidad= rs.getString(4);
          	String telefono= rs.getString(5);
          	
          	miprofe= new Profesor(id,nifp,nombre,especialidad,telefono);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * comportamiento para cerrar la conexion
	 */
	public void cerrarconexion() {
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
	
	
	/**
	 * comportamiento para resetear(borar) la bbdd
	 */
	public void borrarBBDD() {
		miscript.eliminarbbdd();
	}
	
	/**
	 * comportamiento para crear la bbdd
	 */
	public void crearBBDD() {
		miscript.creartablas();
	}
	
	/**
	 * comportamiento para modificar un campo existente en la bbdd
	 * @param campo
	 * @param tabla
	 * @param nuevovalor
	 * @param campoprimario
	 * @param valorpk
	 */
	public void modificar(String campo,String tabla,String nuevovalor,String campoprimario,String valorpk) {
		miscript.modificar_datos(campo,tabla,nuevovalor,campoprimario,valorpk);
	}
	
	/**
	 * comportamiento para crear un nuevo campo en la bbdd
	 * @param ID
	 * @param NIF
	 * @param nombre
	 * @param especialidad
	 * @param Telefono
	 */
	public void crear(String ID,String NIF,String nombre,String especialidad,String Telefono) {
		miscript.añadir_datos_prof(ID, NIF, nombre, especialidad, Telefono);
	}
	
	
	

}
