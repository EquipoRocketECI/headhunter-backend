package equipo.rocket.headhunterbackend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Diego23p
 */
@Entity
@Table(name="interaccion")
public class Interaccion implements Serializable{
    
    public Interaccion() {
            
    	}
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="tipo")
    private String tipo;
    
    @Column(name="monto")
    private int monto;
    
    @Column(name="comentario")
    private String comentario;
    
    @Column(name="calificacion")
    private int calificacion;
    
    @Column(name="idea")
    private int idea;
    
    @Column(name="usuario")
    private String usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdea() {
        return idea;
    }

    public void setIdea(int idea) {
        this.idea = idea;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
