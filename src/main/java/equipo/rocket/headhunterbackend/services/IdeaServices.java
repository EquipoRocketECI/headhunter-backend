package equipo.rocket.headhunterbackend.services;

import java.util.HashMap;
import java.util.List;


import equipo.rocket.headhunterbackend.model.Idea;



public interface IdeaServices {
    public List<Idea> getAllIdeas() throws Exception;

    public List<Idea> filter(HashMap<String,Object> extraParams);
    
    public Idea addIdea(Idea idea);
    
}
