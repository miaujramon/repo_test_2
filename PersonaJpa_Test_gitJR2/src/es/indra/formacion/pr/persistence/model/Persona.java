package es.indra.formacion.pr.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@Table(name="PERSONA")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique=true, nullable=false)
	private Integer id;

	private Double altura;

	@Column(nullable=false, length=50)
	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Ordenador
	@OneToMany(mappedBy="persona")
	private List<Ordenador> ordenadores;

	public Persona() {
	}

	public Persona(String nombre, String apellido, Date fechaNacimiento,
			Double altura) {
		super();
		this.altura = altura;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAltura() {
		return this.altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ordenador> getOrdenadores() {
		return this.ordenadores;
	}

	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}

	public Ordenador addOrdenadores(Ordenador ordenadores) {
		getOrdenadores().add(ordenadores);
		ordenadores.setPersona(this);

		return ordenadores;
	}

	public Ordenador removeOrdenadores(Ordenador ordenadores) {
		getOrdenadores().remove(ordenadores);
		ordenadores.setPersona(null);

		return ordenadores;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", altura=" + altura + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", nombre=" + nombre + ", ordenadores=" + ordenadores + "]";
	}

	
}