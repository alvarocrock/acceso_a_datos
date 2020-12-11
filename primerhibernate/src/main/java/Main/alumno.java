package Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class alumno {
	
	@Id
	@Column
	int id;
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="IdProfesor")
	private profesor prof;
	
	public alumno() {
	}
	
	public alumno(int id,String nombre,profesor prof) {
		this.id=id;
		this.nombre=nombre;
		this.prof=prof;
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

	public profesor getProf() {
		return prof;
	}

	public void setProf(profesor prof) {
		this.prof = prof;
	}

}
