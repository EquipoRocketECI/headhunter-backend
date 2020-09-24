package equipo.rocket.headhunterbackend.persistance.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.custom.IdeasRepositoryCustom;

public class IdeasRepositoryImpl implements IdeasRepositoryCustom{
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Idea> getAllIdeas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postIdea(Idea idea) {
		Query query = entityManager.createNativeQuery("insert into idea values (NEXTVAL('serialIdea'),?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,?)",Idea.class);
        
		query.setParameter(1,  idea.getNombre()).
			  setParameter(2,  idea.getDescripcion()).
			  setParameter(3,  idea.getFechaLimite()).
			  setParameter(4,  idea.getMontoLimite()).
			  setParameter(5,  idea.getMontoRecolectado()).
			  setParameter(6,  idea.getCategoria()).
			  setParameter(7,  idea.getCalificacion()).
			  setParameter(8,  idea.isAdquisiciontemprana()).
			  setParameter(9,  idea.isDescuento()).
			  setParameter(10,  idea.isVersionpremium()).
			  setParameter(11,  idea.isPequenasdonaciones()).
			  setParameter(12,  idea.isGrandesinversiones()).
			  setParameter(13,  idea.isExpertospersonal()).
			  setParameter(14,  idea.getImagen()).
			  setParameter(15,  idea.getPropietario()).
			  executeUpdate();
		
	}
	
}
