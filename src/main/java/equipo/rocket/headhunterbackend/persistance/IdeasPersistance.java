package equipo.rocket.headhunterbackend.persistance;

import java.util.Set;

import equipo.rocket.headhunterbackend.model.Idea;

public interface IdeasPersistance {

    public Set<Idea> getAllIdeas();

}
