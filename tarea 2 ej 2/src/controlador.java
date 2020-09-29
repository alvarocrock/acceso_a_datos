import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class controlador {

	//estado
	protected ArrayList <centro> miscentros;
	protected ArrayList <centro> centros_bianrios;
	
	
	
	static final String fichero="centros.txt";
	static final String destino="binario.txt";
	static final String ordenado= "ordenado.txt";
	
	
	//contructor
	public controlador() {
		miscentros= new ArrayList();
		centros_bianrios = new ArrayList();
		
	}
	
	//resto comportamientos
	
	public void CargarCentros() {
		
		
		String siguientelinea="";
		File miFichero = new File(fichero);
		Scanner in = null;
		centro micentro=null;
		try {
			in = new Scanner(miFichero);
			
			while (in.hasNext()) {
				siguientelinea = in.nextLine();
				micentro= new centro(siguientelinea);
				miscentros.add(micentro);
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void EscribirFicheroBinario() {
		File fichero=null;
		FileOutputStream output=null;
		ObjectOutputStream out=null;
		

		
		try {
			
		
			fichero= new File(destino);
			
			if (!fichero.exists()) {
				//creamos el fichero
			}
			output= new FileOutputStream(fichero);
			out = new ObjectOutputStream(output);
		
			out.writeObject(miscentros);
			

			out.close();
			
			if (fichero!=null) {
				output.close();
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	
}
