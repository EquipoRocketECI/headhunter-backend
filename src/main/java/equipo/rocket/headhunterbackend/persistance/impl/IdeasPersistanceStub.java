package equipo.rocket.headhunterbackend.persistance.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;

@Component("idp")
public class IdeasPersistanceStub implements IdeasPersistance {
    private ArrayList<Idea> ideas;

    public IdeasPersistanceStub() {
        ideas = new ArrayList<Idea>();
        Idea idea1 = new Idea("nombre1", "descripcion1", new Date(), 10000, 1000, "categoria", 5, "imagen");
        Idea idea2 = new Idea("nombre2", "descripcion2", new Date(), 10000, 1000, "categoria", 5, "imagen");
        Idea idea3 = new Idea("nombre3", "descripcion3", new Date(), 10000, 1000, "categoria", 5, "imagen");
        Idea idea4 = new Idea("nombre4", "descripcion4", new Date(), 10000, 1000, "categoria", 5, "imagen");

        ideas.add(idea1);
        ideas.add(idea2);
        ideas.add(idea3);
        ideas.add(idea4);
    }

    @Override
    public List<Idea> getAllIdeas() {
        System.out.println(ideas.toString()+"ideas!!!!!!!!!");
        return ideas;
        
    }

    @Override
    public Idea postIdea(Idea idea) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
