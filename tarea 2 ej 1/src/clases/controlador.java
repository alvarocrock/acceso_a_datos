package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class controlador {
	//controlador
	//estado
	ArrayList<String> lista_par;
	ArrayList<String> lista_impar;
	
	//contante fichero 1
	static final String fichero_impar = "fichero1.txt"; 
	
	
	
	//constate fichero 2
	static final String fichero_par = "fichero2.txt";
	
	
	
	
	//constructor
	public controlador() {
		
		lista_par= new ArrayList();
		lista_impar= new ArrayList();
	}
	
	//resto comportamientos
	
	//comportamiennto para cargar lista impar
	public void cargar_impares() {
	String siguientelinea="";
	File miFichero = new File(fichero_impar);
	Scanner in = null;
	String componente =null;
	try {
		in = new Scanner(miFichero);
		//siguientelinea = in.nextLine();
		while (in.hasNext()) {
			siguientelinea = in.nextLine();	
			componente= siguientelinea;
			lista_impar.add(componente);
			//siguientelinea = in.nextLine();	
		}
		//componente=siguientelinea;
		//lista_impar.add(componente);
		in.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	
	
	//comportamiento para cargar lista par
	public void cargar_pares() {
		String siguientelinea="";
		File miFichero = new File(fichero_par);
		Scanner in = null;
		String componente =null;
		try {
			in = new Scanner(miFichero);
			//siguientelinea = in.nextLine();
			while (in.hasNext()) {
				
				siguientelinea = in.nextLine();	
				componente= siguientelinea;
				lista_par.add(componente);
				
			}
			//componente= siguientelinea;
			//no se añadia la ultima linea, se salia del bucle
			//lista_par.add(componente);
			in.close();
			invertir_par();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
	
	
	
	//comportamiento para invertir la lista par
	
	private void invertir_par() {
		Collections.reverse(lista_par);
	}
	
	
	
	//comportamiento para escribir el mensaje
	
	public void escribir_mensaje() {
		int index=0;
		while (lista_par.size()>index || lista_impar.size()>index) {
			
			//if (index!=lista_par.size()-1 || index!=lista_impar.size()-1 ) {
			if (index%2!=0) {
				if (lista_par.size()>index) {
					//si es par añadimos el valor de la lista par
					System.out.println(lista_par.get(index)+" ");
					index++;
					} else {
						index++;
					}
			} else {
				if (lista_impar.size()>index) {
					//si es impar añadimos el valor de la lista impar
					System.out.println(lista_impar.get(index)+" ");
					index++;
					} else {
						index++;
					}
					}
			//} else {
				//break;
			//}
				
			
			
		}
	}
	
	
	

}
