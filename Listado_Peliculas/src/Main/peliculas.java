package Main;

public class peliculas {
	//estado
	protected String titulo;
	protected String año;
	protected String calidad;
	protected String formato;
	
	
	//comportamiento
	/**
	 * constructor de pelicula, hace faltaa pasarle un serializado x(/d).kmv o mp4
	 * @param serializado
	 */
	public peliculas(String serializado) {
		String [] Lista = serializado.split("[(]");
		titulo= Lista[0];
		String [] Lista2 = Lista[1].split("[)]");
		año= Lista2[0];
		String [] Lista3 = Lista2[1].split("[.]");
		calidad=Lista3[0];
		formato=Lista3[1];
	}

	
	//resto
	/**
	 * comportaamiento que serializa a string
	 */
	public String toString() {
		
		return (titulo+";"+año+";"+calidad+";"+formato+"\n");
	}
}
