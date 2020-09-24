package equipo.rocket.headhunterbackend.services;

import java.util.HashMap;
import java.util.List;


import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.HeadHunterNotFoundException;



public interface IdeaServices {
    public List<Idea> getAllIdeas() throws Exception;

    public List<Idea> filter(HashMap<String,Object> extraParams);
    
    public void addIdea(Idea idea);

	public Idea getIdeaByID(int idIdea) throws  HeadHunterNotFoundException;
    
}
