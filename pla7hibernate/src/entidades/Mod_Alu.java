package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mod_alu")
public class Mod_Alu {

	@Id
	@Column(name = "idmod_alu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmod_alu;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,	CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idmodulo")
	private Modulos modulos;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,	CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idalumno")
	private Alumnos alumnos;


	// Constructor
	
	public Mod_Alu() {
	}

	public Mod_Alu(Modulos modulos, Alumnos alumnos) {
		super();
		this.modulos = modulos;
		this.alumnos = alumnos;
	}

	// getters
	
	public int getIdmod_alu() {return idmod_alu;}

	public Modulos getModulos() {return modulos;}

	public Alumnos getAlumnos() {return alumnos;}
	
	// setters

	public void setIdmod_alu(int idmod_alu) {this.idmod_alu = idmod_alu;}

	public void setModulos(Modulos modulos) {this.modulos = modulos;}

	public void setAlumnos(Alumnos alumnos) {this.alumnos = alumnos;}

}
