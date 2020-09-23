package equipo.rocket.headhunterbackend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idea {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechalimite;
    private int montolimite;
    private int montorecolectado;
    private String categoria;
    private int calificacion;
    private String imagen;

    
    public Idea(){

    }
	public Idea(String nombre, String descripcion, Date fechaLimite, int montoLimite, int montoRecolectado,
			String categoria, int calificacion, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechalimite = fechaLimite;
		this.montolimite = montoLimite;
		this.montorecolectado = montoRecolectado;
		this.categoria = categoria;
		this.calificacion = calificacion;
		this.imagen = imagen;
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
		return fechalimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechalimite = fechaLimite;
	}
	public int getMontoLimite() {
		return montolimite;
	}
	public void setMontoLimite(int montoLimite) {
		this.montolimite = montoLimite;
	}
	public int getMontoRecolectado() {
		return montorecolectado;
	}
	public void setMontoRecolectado(int montoRecolectado) {
		this.montorecolectado = montoRecolectado;
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
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
