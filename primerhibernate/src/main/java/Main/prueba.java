package Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class prueba {
	
	@Id
	int id;
	//@Column
	String nombre;
	
	protected prueba() {
	}

	public prueba(int miid,String minombre) {
		id=miid;
		nombre=minombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
