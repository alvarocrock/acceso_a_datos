import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class main implements ConstantesDeUsuario{
	

	public static void main(String[] args) {
		
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.prepareCall("call iva_nota(?);");
	
	      stmt.execute("call iva_nota(40);");
	      

	      

	      //System.out.println("Tabla "+ nombretabla+ " creada");
	      

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
	public static Connection conectar() {
		java.sql.Connection conexion = null;
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            //System.out.println("Conexi�n OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexi�n");
            e.printStackTrace();
        }
        
        return conexion;
		
	}

}
