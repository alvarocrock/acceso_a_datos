import java.io.Serializable;

public class centro implements Serializable{
	//estado
	protected String Codigo;
	protected String Denominacion;
	protected String Nombre;
	protected String Dependencia;
	protected String Domicilio;
	protected String Localidad;
	protected String Municipio;
	protected String Provincia;
	protected String Cod_Post;
	protected String Telefono;
	protected String Enseñanzas;
	
	static final String espacio="                        ";
	
	//constructor
	
	public centro(String serializado) {
		String [] Lista = serializado.split(";");
		Codigo= Lista[0];
		Denominacion=Lista[1];
		Nombre=Lista[2];
		Dependencia=Lista[3];
		Domicilio= Lista[4];
		Localidad= Lista[5];
		Municipio=Lista[6];
		Provincia=Lista[7];
		Cod_Post=Lista[8];
		Telefono=Lista[9];
		Enseñanzas=Lista[10];
	}
	
	//resto comportamientos
	
	public String imprimir_fichero() {
		String mistring= "Codigo: "+ Codigo + espacio + "Denominación: "+ Denominacion + "\n"
					+"Nombre: "+ Nombre + espacio+ "Dependencia: "+ Dependencia + "\n"
					+"Domicilio: "+ Domicilio + espacio+ "Localidad: "+ Localidad + "\n"
					+"Municipio: "+ Municipio + espacio+ "Provincia: "+ Provincia + "\n"
					+"Cod_Postal: "+ Cod_Post + espacio+ "Teléfono: "+ Telefono + "\n"
					+"Enseñanzas: "+ Enseñanzas +"\n";
		return mistring;
	}

}
