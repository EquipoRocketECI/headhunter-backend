package equipo.rocket.headhunterbackend.persistance.repositories.custom;

import equipo.rocket.headhunterbackend.model.Interaccion;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author EquipoRocketEci
 */
public interface InteraccionRepositoryCustom {
    
    @Transactional
    public void postInteraccion(Interaccion interaccion);
    
    @Transactional
    public List<Interaccion> getInteraccionByIdeaAndTipo (int idea, String tipo);
    
    @Transactional
    public List<Interaccion> getInteraccionByUser(String user);
    
    @Transactional
    public void deleteInteraccion(int interacionId);
    
}
