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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	prueba1A1 prueba1;
	
	public prueba1A1 getPrueba() {
		return prueba1;
	}

	public void setPrueba(prueba1A1 prueba) {
		this.prueba1 = prueba;
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
