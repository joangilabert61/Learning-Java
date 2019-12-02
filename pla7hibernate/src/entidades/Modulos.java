package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulos {
	
	@Id
	@Column(name = "idmodulo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmodulo;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,	CascadeType.DETACH, CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name = "idprofesor")
	private Profesores profesores;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,	CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "alumnos_modulos",joinColumns = @JoinColumn(name="idmodulo"), inverseJoinColumns = @JoinColumn(name="idalumno"))
	private List<Alumnos> alumnos;


	// Constructor
	
	public Modulos() {
	}

	public Modulos(Profesores profesores, String nombre) {
		super();
		this.nombre = nombre;
		this.profesores=profesores;
	}

	// getters
	
	public int getIdmodulo() {return idmodulo;}

	public Profesores getProfesores() {return profesores;}

	public String getNombre() {return nombre;}
	
	public List<Alumnos> getAlumnos() {return alumnos;}

	// setters
	
	public void setIdmodulo(int idmodulo) {this.idmodulo = idmodulo;}

	public void setProfesores(Profesores profesores) {this.profesores = profesores;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public void setAlumnos(List<Alumnos> alumnos) {this.alumnos = alumnos;}
	
	//
	
	public void addModulo(Alumnos alumno) {
		if (alumnos == null) { alumnos = new ArrayList<Alumnos>(); }
		alumnos.add(alumno);
	}
		
	
	@Override
	public String toString() {
		return "Modulos [idmodulo=" + idmodulo + ", nombre profesor=" + profesores + ", nombre=" + nombre + "]";
	}

}
