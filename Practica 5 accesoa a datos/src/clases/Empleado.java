package clases;

import java.io.Serializable;

public class Empleado implements Serializable{
	private static final long serialVersionUID = -2873344211410398459L;
	 
    //Constantes
    /**
     * Constante SALARIO_DEF
     */
    protected final static double SALARIO_DEF=600;
	 /**
     * Nombre del empleado 
     */
    protected String nombre;
    /**
     * Apellido del empleado
     */
    protected String apellido;
    /**
     * Edad del empleado
     */
    protected int edad;
    /**
     * Salario del empleado
     */
    protected double salario;
    
    public Empleado(String nombre, String apellido){
        this (nombre, apellido, 0, SALARIO_DEF);
    }
     
 
    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	/**
     * Constructor con 3 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     */
    public Empleado (String nombre, String apellido, int edad){
        this (nombre, apellido, edad, SALARIO_DEF);
    }
    /**
     * Constructor con 4 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     * @param salario salario del empleado
     */
    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.salario=salario;
    }

    
    
}
