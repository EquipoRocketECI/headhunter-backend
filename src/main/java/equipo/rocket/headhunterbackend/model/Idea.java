package equipo.rocket.headhunterbackend.model;

import java.util.Date;

public class Idea {

    private String nombre;
    private String descripcion;
    private Date fechaLimite;
    private int montoLimite;
    private int montoRecolectado;
    private String categoria;
    private int calificacion;
    private String imagen;
    
	public Idea(String nombre, String descripcion, Date fechaLimite, int montoLimite, int montoRecolectado,
			String categoria, int calificacion, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
		this.montoLimite = montoLimite;
		this.montoRecolectado = montoRecolectado;
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


}
