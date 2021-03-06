package equipo.rocket.headhunterbackend.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.IdeasRepositoryCustom;

public interface IdeasRepository extends JpaRepository<Idea, Integer>, IdeasRepositoryCustom{
	
}
