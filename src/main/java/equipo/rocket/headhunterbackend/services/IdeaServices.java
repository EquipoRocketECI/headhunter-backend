package equipo.rocket.headhunterbackend.services;

import java.util.Set;



import equipo.rocket.headhunterbackend.model.Idea;


public interface IdeaServices {
    public Set<Idea> getAllIdeas() throws Exception
    
    public Idea addIdea(Idea idea)
    
}
