package equipo.rocket.headhunterbackend.services;

import java.util.List;


import equipo.rocket.headhunterbackend.model.Idea;



public interface IdeaServices {
    public List<Idea> getAllIdeas() throws Exception;
    
    public Idea addIdea(Idea idea);
    
}
