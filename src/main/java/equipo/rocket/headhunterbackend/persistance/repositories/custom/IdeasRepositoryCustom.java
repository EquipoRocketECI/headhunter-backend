package equipo.rocket.headhunterbackend.persistance.repositories.custom;

import java.util.List;

import javax.transaction.Transactional;

import equipo.rocket.headhunterbackend.model.Idea;

public interface IdeasRepositoryCustom {
	
	public List<Idea> getAllIdeas();
    
	@Transactional
    public void postIdea(Idea idea);
}
