import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class controlador {
	
	//estado
	private ArrayList <empleados> lista_emple;
	private ArrayList <empleados> lista_emple_seri;
	
	//constante fichero no serializado
		static final String arch_noserializado= "noserializado.txt";
			
		//contante fichero serializado
		static final String arch_serializado= "serializado.txt";
	
	//contructor
	
	public controlador() {
		lista_emple_seri = new ArrayList();
		lista_emple = new ArrayList();
	}
	
	
	
	//primero leemos el fichero y llenamos la array
		public void leer_empleados() {
			
			String siguientelinea="";
			File miFichero = new File(arch_noserializado);
			Scanner in = null;
			empleados miemple=null;
			try {
				in = new Scanner(miFichero);
				siguientelinea = in.nextLine();
				while (in.hasNext()) {
					miemple= new empleados(siguientelinea);
					lista_emple.add(miemple);
					siguientelinea = in.nextLine();	
				}
				System.out.println("usuarios del fichero no serializado"+"\n");
				mostrar_noserializado();
				in.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		//pasamos la array a bianrio y creamos el fichero no serializado
		
		public void Serializar() throws IOException {
			File fichero=null;
			FileOutputStream output=null;
			ObjectOutputStream out=null;
			

			
			try {
				
			
				fichero= new File(arch_serializado);
				
				if (!fichero.exists()) {
					//creamos el fichero
				}
				output= new FileOutputStream(fichero);
				out = new ObjectOutputStream(output);
			
				out.writeObject(lista_emple);
				

				out.close();
				
				if (fichero!=null) {
					output.close();
					
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		
		//leemos del fichero en bianrio y lo mostramos en consola 
		
		public void leer_empleados_b() {
			
			
		
					File archivo =null;
					FileInputStream fichero=null;
					ObjectInputStream ost=null;
					try {
						archivo= new File(arch_serializado);
						fichero = new FileInputStream(archivo);
						ost = new ObjectInputStream(fichero);
						lista_emple_seri = (ArrayList<empleados>) ost.readObject();
						ost.close();
						fichero.close();
						System.out.println("usuarios del fichero serializado"+"\n");
						mostrar_deserializado();
					} catch (IOException ex) {
						ex.printStackTrace();
						return;
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
						return;
					}
					
					

			
			
		}
		
		public void mostrar_deserializado() {
			int size= lista_emple_seri.size();
			for(int cont=0;cont<size;cont++) {
				System.out.println(lista_emple_seri.get(cont).serializar());
			}
		}
			
			public void mostrar_noserializado() {
				int size= lista_emple.size();
				for(int cont=0;cont<size;cont++) {
					System.out.println(lista_emple.get(cont).serializar());
					
				}
			
		}


		
	
	

}
