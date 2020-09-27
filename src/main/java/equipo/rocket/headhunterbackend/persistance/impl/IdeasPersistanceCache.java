package equipo.rocket.headhunterbackend.persistance.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;
import equipo.rocket.headhunterbackend.persistance.repositories.IdeasRepository;

public class IdeasPersistanceCache implements IdeasPersistance {

    private HashMap<Integer,Idea> ideas;

    @Autowired
    private IdeasRepository ideasRepository;

    public IdeasPersistanceCache(){
        Iterator<Idea> iterator = ideasRepository.findAll().iterator();

        while(iterator.hasNext()){
            Idea idea = iterator.next();
            ideas.put(idea.getId(), idea);
        }

    }

    @Override
    public List<Idea> getAllIdeas() {
        return new ArrayList<>(ideas.values());
    }

    @Override
    public Idea postIdea(Idea idea) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
