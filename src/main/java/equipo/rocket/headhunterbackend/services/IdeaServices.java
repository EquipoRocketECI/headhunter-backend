package equipo.rocket.headhunterbackend.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;

@Service
public class IdeaServices {
    
    @Autowired
    IdeasPersistance idp =null;

    public Set<Idea> getAllIdeas() throws Exception{
        return idp.getAllIdeas();
    }
}
