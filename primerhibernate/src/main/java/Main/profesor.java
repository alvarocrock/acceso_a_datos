package Main;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class profesor {
	
	@Id
	@Column(name="IdProf")
	private int id;
	@Column
	private String nombre;
	@Column
	private String ape1;
	@Column
	private String ape2;
	
	@OneToMany(mappedBy="prof",cascade= CascadeType.ALL)
	private Set<alumno> alumnos;
	
	
	    public profesor(){
	    }

	     public profesor(int id, String nombre, String ape1, String ape2) {
	        this.id = id;
	        this.nombre = nombre;
	         this.ape1 = ape1;
	        this.ape2 = ape2;
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

		public String getApe1() {
			return ape1;
		}

		public void setApe1(String ape1) {
			this.ape1 = ape1;
		}

		public String getApe2() {
			return ape2;
		}

		public void setApe2(String ape2) {
			this.ape2 = ape2;
		}

		public Set<alumno> getAlumnos() {
			return alumnos;
		}

		public void setAlumnos(Set<alumno> alumnos) {
			this.alumnos = alumnos;
		}

		
	
	 }

