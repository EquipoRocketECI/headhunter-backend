package equipo.rocket.headhunterbackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="idea")
public class Idea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="descripcion")
    private String descripcion;
    
	@Column(name="fechalimite")
	private Date fechaLimite;
    
	@Column(name="montolimite")
	private int montoLimite;
    
	@Column(name="montorecolectado")
	private int montoRecolectado;
    
	@Column(name="categoria")
	private String categoria;
    
	@Column(name="calificacion")
	private int calificacion;
	
	@Column(name="adquisiciontemprana")
	private boolean adquisiciontemprana;
	
	@Column(name="descuento")
	private boolean descuento;
	
	@Column(name="versionpremium")
	private boolean versionpremium;
	
	@Column(name="pequenasdonaciones")
	private boolean pequenasdonaciones;
	
	@Column(name="grandesinversiones")
	private boolean grandesinversiones;
	
	@Column(name="expertospersonal")
	private boolean expertospersonal;
    
	@Column(name="imagen")
	private String imagen;
    
	@Column(name="fechapublicacion")
	private Date fechapublicacion;
	
	@Column(name="propietario")
	private String propietario;
    
	public Idea() {
		
	}

        
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public int getMontoLimite() {
		return montoLimite;
	}
	public void setMontoLimite(int montoLimite) {
		this.montoLimite = montoLimite;
	}
	public int getMontoRecolectado() {
		return montoRecolectado;
	}
	public void setMontoRecolectado(int montoRecolectado) {
		this.montoRecolectado = montoRecolectado;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public boolean isAdquisiciontemprana() {
		return adquisiciontemprana;
	}


	public void setAdquisiciontemprana(boolean adquisiciontemprana) {
		this.adquisiciontemprana = adquisiciontemprana;
	}


	public boolean isDescuento() {
		return descuento;
	}


	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}


	public boolean isVersionpremium() {
		return versionpremium;
	}


	public void setVersionpremium(boolean versionpremium) {
		this.versionpremium = versionpremium;
	}


	public boolean isPequenasdonaciones() {
		return pequenasdonaciones;
	}


	public void setPequenasdonaciones(boolean pequenasdonaciones) {
		this.pequenasdonaciones = pequenasdonaciones;
	}


	public boolean isGrandesinversiones() {
		return grandesinversiones;
	}


	public void setGrandesinversiones(boolean grandesinversiones) {
		this.grandesinversiones = grandesinversiones;
	}


	public boolean isExpertospersonal() {
		return expertospersonal;
	}


	public void setExpertospersonal(boolean expertospersonal) {
		this.expertospersonal = expertospersonal;
	}


	public Date getFechapublicacion() {
		return fechapublicacion;
	}


	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}


	public String getPropietario() {
		return propietario;
	}


	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
