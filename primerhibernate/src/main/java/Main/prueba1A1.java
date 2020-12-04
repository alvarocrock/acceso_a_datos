package Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table (name = "dos")
public class prueba1A1 {
	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name="foreigngen", parameters = @Parameter(name = "property", value="prueba"))
	int id;
	@Column
	String desc;
	@OneToOne(mappedBy = "prueba")
	prueba prueba;
	
	public prueba1A1(String desc) {
		this.desc=desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(prueba prueba) {
		this.prueba = prueba;
	}

}
