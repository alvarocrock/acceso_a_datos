package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	
	
	public static void main(String[] args) {
		Controlador micontro= new Controlador();
		micontro.CargarPelis();
		micontro.escribir_fichero();

	}

}
