package equipo.rocket.headhunterbackend.persistance.repositories.custom.impl;

import equipo.rocket.headhunterbackend.model.Interaccion;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.InteraccionRepositoryCustom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author EquipoRocketEci
 */
public class InteraccionRepositoryImpl implements InteraccionRepositoryCustom{
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void postInteraccion(Interaccion interaccion) {
        Query query = entityManager.createNativeQuery("insert into interaccion values (NEXTVAL('serialInteraccion'), ? , ? , ? , ? , ? , ?)",Interaccion.class);
        
        query.setParameter(1, interaccion.getTipo())
             .setParameter(2, interaccion.getMonto())
             .setParameter(3, interaccion.getComentario())
             .setParameter(4, interaccion.getCalificacion())
             .setParameter(5, interaccion.getIdea())
             .setParameter(6, interaccion.getUsuario())
             .executeUpdate();
        
    }

    @Override
    public List<Interaccion> getInteraccionByIdeaAndTipo(int idea, String tipo) {
        Query query = entityManager.createNativeQuery("select * from interaccion where idea=? and tipo=?",Interaccion.class);
        
        query.setParameter(1, idea )
             .setParameter(2, tipo );
        
        return query.getResultList();
    }
    
    @Override
    public List<Interaccion> getInteraccionByUser(String user){
        
        Query query = entityManager.createNativeQuery("select * from interaccion LEFT JOIN idea ON interaccion.idea = idea.id where interaccion.usuario=?",Interaccion.class);
        
        query.setParameter(1, user );
        
        return query.getResultList();
        
    }
    
}
