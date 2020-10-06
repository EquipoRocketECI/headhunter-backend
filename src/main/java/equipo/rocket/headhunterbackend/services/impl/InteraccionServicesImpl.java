package equipo.rocket.headhunterbackend.services.impl;

import equipo.rocket.headhunterbackend.model.Interaccion;
import equipo.rocket.headhunterbackend.persistance.repositories.InteraccionRepository;
import equipo.rocket.headhunterbackend.services.InteraccionServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EquipoRocketEci
 */
@Service("interaccionServices")
public class InteraccionServicesImpl implements InteraccionServices{
    
    @Autowired
    private InteraccionRepository interaccionRepository;
    
    @Override
    public void postInteraccion(Interaccion interaccion){
        interaccionRepository.postInteraccion(interaccion);
    }
    
    @Override
    public List<Interaccion> getInteraccionByIdeaAndTipo (int idea, String tipo){
        return interaccionRepository.getInteraccionByIdeaAndTipo(idea, tipo);
    }
    
    @Override
    public List<Interaccion> getInteraccionByUser(String user){
        return interaccionRepository.getInteraccionByUser(user);
    }
    
}
