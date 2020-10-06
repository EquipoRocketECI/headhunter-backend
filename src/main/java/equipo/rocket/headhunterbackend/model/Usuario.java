package equipo.rocket.headhunterbackend.model;

import java.util.Date;
import javax.persistence.*;


import java.io.Serializable;

@Entity//(name="usuario")
@Table(name="usuario")
public class Usuario implements Serializable{     
	
    	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="correo")
	private String correo;
        
        @Column(name="contrasena")
        private String contrasena; 
        
        @Column(name="nombrecompleto")
        private String nombrecompleto;
        
     
        public Usuario() {
            
    	}
        
    public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}        
        
        public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto  = nombrecompleto;
	}
	
}

