package equipo.rocket.headhunterbackend.persistance.repositories.custom.impl;

import java.util.ArrayList;
import java.util.Date;
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

    private ArrayList<Idea> ideasStub;

    @PersistenceContext
    EntityManager entityManager;

    public IdeasRepositoryImpl() {
        ideasStub = new ArrayList<Idea>();
        Idea idea1 = new Idea("HeadHunter",
                "HeadHunter es una plataforma para emprendedores que buscan ayuda financiera y logística para llevar a cabo sus ideas a la realidad",
                new Date(), 10000, 1000, "Educacion", 5, "imagen");
        Idea idea2 = new Idea("MyDoctor", "Sistema para pedir consejos de médicos", new Date(), 1000000, 100000,
                "Salud", 3, "imagen");
        Idea idea3 = new Idea("BlueApron",
                "Our food system—the way in which food is grown and distributed—is complicated, and making good choices for your family can be difficult. We are changing that: By partnering with farmers to raise the highest-quality ingredients, by creating a distribution system that delivers ingredients at a better value and by investing in the things that matter most—our environment and our communities",
                new Date(), 2500000, 100000, "Gastronomia", 5, "imagen");
        Idea idea4 = new Idea("PokemonGo", "juego de AR", new Date(), 50000, 10000, "Cultura", 5, "imagen");
        Idea idea5 = new Idea("MyDoctor2", "Sistema para pedir consejos de médicos", new Date(), 1000000, 100000,
                "Salud", 5, "imagen");
        Idea idea6 = new Idea("HeadHunter",
                "HeadHunter es una plataforma para emprendedores que buscan ayuda financiera y logística para llevar a cabo sus ideas a la realidad",
                new Date(), 10000, 1000, "Educacion", 1, "imagen");

        ideasStub.add(idea1);
        ideasStub.add(idea2);
        ideasStub.add(idea3);
        ideasStub.add(idea4);
        ideasStub.add(idea5);
        ideasStub.add(idea6);
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideasStub;
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
    }

}
