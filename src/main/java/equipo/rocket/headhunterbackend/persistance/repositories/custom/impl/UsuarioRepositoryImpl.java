package equipo.rocket.headhunterbackend.persistance.repositories.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.UsuarioRepositoryCustom;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Usuario> getNombreCompleto(String correo) {
		Query query = entityManager.createNativeQuery("select * from usuario where correo=?",Usuario.class);
		
		query.setParameter(1, correo);
		return query.getResultList();
		
		
	}
	
	@Override
	public void changePassword(String correo ,String nuevaContrasena) {
		Query query = entityManager.createNativeQuery("update usuario set contrasena=? where correo=? ",Usuario.class);
        
    	query.setParameter(1,nuevaContrasena)
            .setParameter(2,correo)
            .executeUpdate();
		
	}

	@Override
	public void changeNombreCompleto(String correo, String nuevoNombreCompleto) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("update usuario set nombrecompleto=? where correo=? ",Usuario.class);
        
    	query.setParameter(1,nuevoNombreCompleto)
            .setParameter(2,correo)
            .executeUpdate();

	}
}