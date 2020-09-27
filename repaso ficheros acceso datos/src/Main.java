import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	//hat que crear el esatado
	controlador micontrolador;
	
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//prueba de fuego
		//System.out.println("hola mundo");
		controlador micontrolador= new controlador();
		micontrolador.leer_empleados();
		
		try {
			micontrolador.Serializar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		micontrolador.leer_empleados_b();
		
		
		
	}
	
	
	
	
}
