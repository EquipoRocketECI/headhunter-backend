package equipo.rocket.headhunterbackend.persistance.repositories.custom;

import javax.transaction.Transactional;

import equipo.rocket.headhunterbackend.model.Idea;

public interface IdeasRepositoryCustom {
    
	@Transactional
    public void postIdea(Idea idea);
}
