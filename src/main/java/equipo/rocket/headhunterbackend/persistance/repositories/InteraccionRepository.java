package equipo.rocket.headhunterbackend.persistance.repositories;

import equipo.rocket.headhunterbackend.model.Interaccion;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.InteraccionRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego23p
 */
public interface InteraccionRepository extends JpaRepository<Interaccion, Integer>, InteraccionRepositoryCustom{
    
}
