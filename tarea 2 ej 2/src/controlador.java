import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
	
	/**
	 * comportaamiento que carga los centros a opartir del centro inicial
	 */
	
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
	
	/**
	 * comportamiento que pasa la array a binario y lo escribe en el fichero binario
	 */
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
	
	/**
	 * comportamiento que deserializa el fichero binario y carga la array binaria
	 */
	
	public void LeerFicheroBinario() {
		
		
		
		File archivo =null;
		FileInputStream fichero=null;
		ObjectInputStream ost=null;
		try {
			archivo= new File(destino);
			fichero = new FileInputStream(archivo);
			ost = new ObjectInputStream(fichero);
			centros_bianrios = (ArrayList<centro>) ost.readObject();
			ost.close();
			fichero.close();
			//System.out.println("usuarios del fichero serializado"+"\n");
			//mostrar_deserializado();
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return;
		}
	}
	
	/**
	 * comportamiento que escribe el fichero con el formato deseado
	 */
	public void EscribirOrdenado() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ordenado);
            pw = new PrintWriter(fichero);

            for (int cont = 0; cont <centros_bianrios.size();cont++) {
            	pw.print(centros_bianrios.get(cont).imprimir_fichero());
            	
            }

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
		
}
