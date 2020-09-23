package equipo.rocket.headhunterbackend.persistance;

import java.util.List;

import equipo.rocket.headhunterbackend.model.Idea;

public interface IdeasPersistance {

    public List<Idea> getAllIdeas();
    
    public Idea postIdea(Idea idea);

}
