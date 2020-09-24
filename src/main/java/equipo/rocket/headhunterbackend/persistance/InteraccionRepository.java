package equipo.rocket.headhunterbackend.persistance;

import equipo.rocket.headhunterbackend.model.Interaccion;
import equipo.rocket.headhunterbackend.persistance.custom.InteraccionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego23p
 */
public interface InteraccionRepository extends JpaRepository<Interaccion, Integer>, InteraccionRepositoryCustom{
    
}
