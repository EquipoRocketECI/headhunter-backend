package equipo.rocket.headhunterbackend.persistance.repositories.custom;

import java.util.Set;
import javax.transaction.Transactional;

import java.util.List;
import equipo.rocket.headhunterbackend.model.Usuario;

public interface UsuarioRepositoryCustom {
	
	@Transactional
    public List<Usuario> getNombreCompleto(String correo);
	
	@Transactional
	public void changePassword(String correo, String nuevaContrasena);
	
	@Transactional
	public void changeNombreCompleto(String correo, String nuevoNombreCompleto);
}