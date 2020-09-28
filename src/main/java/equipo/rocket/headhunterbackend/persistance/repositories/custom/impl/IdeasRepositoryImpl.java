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

import equipo.rocket.headhunterbackend.model.Idea;
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
    public void postIdea(Idea idea) {
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
    }

}
