package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesores {

	@Id
	@Column(name = "idprofesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="profesores",cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Modulos> modulos;

	// Constructor
	
	public Profesores() {
	}

	public Profesores(String nombre, String dni, String email) {
		super();
		this.nombre = nombre;
		this.dni=dni;
		this.email = email;
	}

	// getters
	
	public int getIdprofesor() {return idprofesor;}

	public String getNombre() {return nombre;}

	public String getDni() {return dni;}

	public String getEmail() {return email;}
	
	public List<Modulos> getModulos() {return modulos;}
	
	// setters

	public void setIdprofesor(int idprofesor) {this.idprofesor = idprofesor;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setDni(String dni) {this.dni = dni;}

	public void setEmail(String email) {this.email = email;}
	
	public void setModulos(List<Modulos> modulos) {this.modulos = modulos;}
	
	@Override
	public String toString() {
		String wModulos="";
		for (Modulos x:modulos) {wModulos+=x.getNombre()+" -+- ";}
		return "Profesores [idprofesor=" + idprofesor + ", nombre=" + nombre + ", dni=" + dni + ", email=" + email + " ,Modulos=" + wModulos + "]";
	}
}
