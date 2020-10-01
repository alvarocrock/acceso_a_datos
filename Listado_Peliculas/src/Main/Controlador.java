package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador {
	
	//estado
	ArrayList<peliculas> peliculas= new ArrayList();
	
	static final String url="C:\\Users\\alvar\\Desktop\\peliculas";
	static final String fichero_pelis="fichero_pelis.txt";
	
	//contructor
	public Controlador() {
		peliculas=new ArrayList();
	}
	
	
	
	//resto comportamientos
	/**
	 * Comprtamiennto que carga la array list
	 */
	
	public void CargarPelis() {
		peliculas mipeli;
		
		File carpeta = new File(url);
		Pattern patron = Pattern.compile(".(kmv|mp4)");
		String[] listado = carpeta.list();
		Matcher m;
		if (listado == null || listado.length == 0) {
		    System.out.println("No hay elementos dentro de la carpeta actual");
		    return;
		}
		else {
		    for (int i=0; i< listado.length; i++) {
		    	m=patron.matcher(listado[i]);
		    	if (m.find()){
		        System.out.println(listado[i]);
		        //crear pelicula
		        mipeli= new peliculas(listado[i]);
		        peliculas.add(mipeli);
		        
		    	}
		    }
		}
	}
	
	/**
	 * Comportamiento que escribe el fichero 
	 */
	public void escribir_fichero() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(fichero_pelis);
            pw = new PrintWriter(fichero);

            for (int cont = 0; cont <peliculas.size();cont++) {
            	pw.print(peliculas.get(cont).toString());
            	
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
