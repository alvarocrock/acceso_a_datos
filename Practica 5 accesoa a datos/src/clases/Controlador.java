package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controlador {
	
	ArrayList<Empleado> lista_emple_bin;
	
	protected final static String FICHEROBINARIO= "fichero_uno_a_uno.dat";
	
	
	
	//contructor
	public Controlador() {
		lista_emple_bin= new ArrayList();
	}
	
	
	//resto comportamientos
	/**
	 * Comportamiento que genera una array list
	 * @return
	 */
	public ArrayList <Empleado> cargar_empleados() {
		ArrayList<Empleado> lista_emple=new ArrayList();
		
		Empleado empleado1=new Empleado("Fernando", "Ureña", 23, 800);
        Empleado empleado2=new Empleado("Antonio", "Lopez", 35, 1000);
        Empleado empleado3=new Empleado("Fernando", "Ureña", 23, 800);
        Empleado empleado4=new Empleado("Antonio", "Lopez", 35, 1000);
        Empleado empleado5=new Empleado("Antonio", "Lopez", 35, 1000);
        Empleado empleado6=new Empleado("Antonio", "Lopez", 35, 1000);
        
        lista_emple.add(empleado1);
        lista_emple.add(empleado2);
        
        lista_emple.add(empleado3);
        lista_emple.add(empleado4);
        lista_emple.add(empleado5);
        lista_emple.add(empleado6);
        
        return lista_emple;
		
	}
	
	/**
	 * Comportamiento que serializa una array list de empleados que se passa como parametro
	 * @param milista
	 */
	public void guardarEmpleados(ArrayList<Empleado> milista) {
	        //Creamos el objeto
			//argar_empleados();
			
	        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FICHEROBINARIO,true))){
	            //Escribimos en un fichero
	          
	        	//recorer lista y añadir uno a uno
	        	for (int cont=0; cont<milista.size();cont++) {
	        		oos.writeObject(milista.get(cont));
	        	}
	           
	           //oos.writeObject(milista);
	           oos.close();
	        }catch(IOException e){
	        }
	}
	
	/**
	 * Comportamiento que muestra empleados de la lista binaria que se carga de la array list <br>
	 * si el valor que se le da es true imprimira por el terminal<br>
	 * si el valor es false escribira un fichero de uno en uno
	 */
	public void imprimir_empleados(boolean mibool) {
		
		if (mibool==true) {
			imprimir_por_terminal();
		} else {
			escribir_fichero();
		
			}
		
		
		}
	
	
	
	/**
	 * Comportamiento para escribir por terminal
	 */

		public void imprimir_por_terminal() {
			File archivo =null;
			FileInputStream fichero=null;
			ObjectInputStream ost=null;
			Empleado mi_emple;
			
				//si es true escribimos en pantalla
			try {
				archivo= new File(FICHEROBINARIO);
				fichero = new FileInputStream(archivo);
				ost = new ObjectInputStream(fichero);
				
				//recorer lista y leeer de uno en uno
				while (true) {
					//cargamos empleado
					try {
						mi_emple=(Empleado) ost.readObject();
						String nombre=mi_emple.getNombre();
						String apellido=mi_emple.getApellido();
						var edad=mi_emple.getEdad();
						var salario=mi_emple.getSalario();
						System.out.println(nombre+" "+apellido+" "+ edad+ " "+ salario);
						System.out.println();
						
						//ost.close();
						//fichero.close();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(EOFException e){
			        }catch(IOException e){
			        }
					
					}
				
				
				
				
				//lista_emple_bin = (ArrayList<Empleado>) ost.readObject();
				
					} catch (IOException ex) {
					ex.printStackTrace();
					return;
					}
			} 
		
		
		/**
		 * comportamiento para escribir fichero uno a uno, usando un subproceso
		 */
		public void escribir_fichero() {
			File archivo =null;
			FileInputStream fichero=null;
			ObjectInputStream ost=null;
			Empleado mi_emple;
			try {
				archivo= new File("fichero_no_bin.txt");
				fichero = new FileInputStream(archivo);
				ost = new ObjectInputStream(fichero);
				while (true) {
					//cargamos empleado
						mi_emple=(Empleado) ost.readObject();
						String nombre=mi_emple.getNombre();
						String apellido=mi_emple.getApellido();
						var edad=mi_emple.getEdad();
						var salario=mi_emple.getSalario();
						escribir_uno((Empleado) ost.readObject());
		
				ost.close();
				fichero.close();
				}
				
				//System.out.println("usuarios del fichero serializado"+"\n");
				//mostrar_deserializado();
			}catch (IOException ex) {
			} catch (ClassNotFoundException ex) {
			} finally {
					
			}
			}
				
		
		
			/**
			 * subproceso para escribir de uno es uno
			 * @param mi_emple
			 */
			public void escribir_uno(Empleado mi_emple) {
			
				FileWriter fichero = null;
		        PrintWriter pw = null;
		        try
		        {
		            fichero = new FileWriter("fichero_no_bin.txt");
		            pw = new PrintWriter(fichero);

		           
		            String nombre=mi_emple.getNombre();
					String apellido=mi_emple.getApellido();
					var edad=mi_emple.getEdad();
					var salario=mi_emple.getSalario();
					pw.println(nombre+" "+apellido+" "+ edad+ " "+ salario+"/n");

		        } catch(EOFException e){
		        } catch (IOException e) {
				}finally {
		           try {
		           // Nuevamente aprovechamos el finally para 
		           // asegurarnos que se cierra el fichero.
		           if (null != fichero)
		              fichero.close();
		           } catch(EOFException e){
		           } catch (IOException e) {
				} finally {
		        
		           }
		        }
		    
		}
			

}
