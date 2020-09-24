package equipo.rocket.headhunterbackend.persistance.custom;

import java.util.Set;
import javax.transaction.Transactional;

import java.util.List;
import equipo.rocket.headhunterbackend.model.Usuario;

public interface UsuarioRepositoryCustom {
	
	@Transactional
    public List<Usuario> getNombreCompleto(String correo);
}