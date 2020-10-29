package equipo.rocket.headhunterbackend.services;

import equipo.rocket.headhunterbackend.model.Interaccion;
import java.util.List;

/**
 *
 * @author EquipoRocketEci
 */
public interface InteraccionServices {
    
    public void postInteraccion(Interaccion interaccion);
    
    public List<Interaccion> getInteraccionByIdeaAndTipo (int idea, String tipo);
            
    public List<Interaccion> getInteraccionByUser(String user);
    
    public void deleteInteraccion(int interacionId);
    
}
