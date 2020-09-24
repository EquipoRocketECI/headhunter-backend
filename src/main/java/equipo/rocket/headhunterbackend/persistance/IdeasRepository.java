package equipo.rocket.headhunterbackend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import equipo.rocket.headhunterbackend.model.Idea;

import equipo.rocket.headhunterbackend.persistance.custom.IdeasRepositoryCustom;

public interface IdeasRepository extends JpaRepository<Idea, Integer>, IdeasRepositoryCustom{
	
}
