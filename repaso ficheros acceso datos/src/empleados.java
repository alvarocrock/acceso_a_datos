import java.io.Serializable;

public class empleados implements Serializable{
	
	//estado
	private String empresa;
	private String edad;
	private String num_emple;
	
	
	//comportamientos
	
	//contructor
	public empleados(String serializado) {
		
		String[] Listapartes= serializado.split(",");
        //s.charAt(X); encuentra caracter en pos x
        empresa= Listapartes[0];
        edad= Listapartes[1];
        num_emple= Listapartes[2];
        
	}
	
	//resto comportamientos
	
	public String serializar() {
		String resultado=null;
		resultado= empresa+" "+edad+" "+num_emple+"\n";
		
		return resultado;
	}

}
