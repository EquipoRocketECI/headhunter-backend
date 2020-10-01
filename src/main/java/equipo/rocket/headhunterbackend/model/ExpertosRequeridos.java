package equipo.rocket.headhunterbackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expertosrequeridos")
public class ExpertosRequeridos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="area")
	private String area;
	
	@Column(name="idea")
	private int idea;
	
	public ExpertosRequeridos(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getIdea() {
		return idea;
	}

	public void setIdea(int idea) {
		this.idea = idea;
	}

}
