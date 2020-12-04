package Main;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "uno")
public class prueba {
	
	@Id
	int id;
	@Column
	String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	prueba1A1 prueba;
	
	public prueba1A1 getPrueba() {
		return prueba;
	}

	public void setPrueba(prueba1A1 prueba) {
		this.prueba = prueba;
	}

	protected prueba() {
	}

	public prueba(int miid,String minombre) {
		id=miid;
		nombre=minombre;
	}
	
	@PrimaryKeyJoinColumn
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
