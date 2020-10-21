package equipo.rocket.headhunterbackend.persistance.repositories.custom.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import equipo.rocket.headhunterbackend.model.ExpertosRequeridos;
import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.repositories.IdeasRepository;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.IdeasRepositoryCustom;

@Component("ir")
public class IdeasRepositoryImpl implements IdeasRepositoryCustom {

    private HashMap<Integer, Idea> ideas;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private IdeasRepository ideasRepository;

    public IdeasRepositoryImpl() {
        refreshCache();
    }

    public void refreshCache() {
        /* Iterator<Idea> iterator = ideasRepository.findAll().iterator();

        while (iterator.hasNext()) {
            Idea idea = iterator.next();
            ideas.put(idea.getId(), idea);
        } */
    }

    @Override
    public List<Idea> getAllIdeas() {
        return new ArrayList<>(ideas.values());
    }

    @Override
    public Idea postIdea(Idea idea) {
        Query query = entityManager.createNativeQuery(
                "insert into idea values (NEXTVAL('serialIdea'),?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,?)", Idea.class);

        query.setParameter(1, idea.getNombre()).setParameter(2, idea.getDescripcion())
                .setParameter(3, idea.getFechaLimite()).setParameter(4, idea.getMontoLimite())
                .setParameter(5, idea.getMontoRecolectado()).setParameter(6, idea.getCategoria())
                .setParameter(7, idea.getCalificacion()).setParameter(8, idea.isAdquisiciontemprana())
                .setParameter(9, idea.isDescuento()).setParameter(10, idea.isVersionpremium())
                .setParameter(11, idea.isPequenasdonaciones()).setParameter(12, idea.isGrandesinversiones())
                .setParameter(13, idea.isExpertospersonal()).setParameter(14, idea.getImagen())
                .setParameter(15, idea.getPropietario()).executeUpdate();

        refreshCache();
        
        Query query2 = entityManager.createNativeQuery("select * from idea where id=(select max(id) from idea)",Idea.class);
		
		
		return (Idea) query2.getResultList().get(0);
        
    }

	@Override
	public void putIdea(Idea idea) {
		Query query = entityManager.createNativeQuery("update idea set nombre=?,descripcion=?,fechalimite=?,montolimite=?,categoria=?,calificacion=?,adquisiciontemprana=?,descuento=?,versionpremium=?,pequenasdonaciones=?,grandesinversiones=?,expertospersonal=?,imagen=? where id=? ",Idea.class);
        
        	query.setParameter(1,idea.getNombre() )
                .setParameter(2,idea.getDescripcion())
                .setParameter(3, idea.getFechaLimite())
                .setParameter(4,  idea.getMontoLimite())
                .setParameter(5,  idea.getCategoria())
                .setParameter(6, idea.getCalificacion())
                .setParameter(7, idea.isAdquisiciontemprana())
                .setParameter(8, idea.isDescuento())
                .setParameter(9, idea.isVersionpremium())
                .setParameter(10, idea.isPequenasdonaciones())
                .setParameter(11, idea.isGrandesinversiones())
                .setParameter(12, idea.isExpertospersonal())
                .setParameter(13, idea.getImagen())
                .setParameter(14, idea.getId())
                .executeUpdate();
		
	}

	@Override
	public void addMonto(int idIdea ,int newMontoRecolectado) {
		Query query = entityManager.createNativeQuery("update idea set montorecolectado=? where id=? ",Idea.class);
        
    	query.setParameter(1,newMontoRecolectado)
            .setParameter(2,idIdea)
            .executeUpdate();
		
	}

	@Override
	public void postExpert(ExpertosRequeridos exp) {
		Query query = entityManager.createNativeQuery(
                "insert into expertosrequeridos values (NEXTVAL('serialExpertosRequeridos'),?,?)", Idea.class);

        query.setParameter(1, exp.getArea())
        	  .setParameter(2, exp.getIdea())
              .executeUpdate();
		
	}

	@Override
	public List<ExpertosRequeridos> getExpertsByIdea(int idIdea) {
        
        Query query = entityManager.createNativeQuery("select * from expertosrequeridos where idea=?",ExpertosRequeridos.class);
		
		query.setParameter(1, idIdea);
		return query.getResultList();
		
	}
    
    

}
