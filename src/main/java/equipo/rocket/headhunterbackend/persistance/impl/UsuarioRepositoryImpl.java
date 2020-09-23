package equipo.rocket.headhunterbackend.persistance.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.custom.UsuarioRepositoryCustom;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Usuario> getNombreCompleto(String correo) {
		Query query = entityManager.createNativeQuery("select * from usuario where correo=?",Usuario.class);
		
		query.setParameter(1, correo);
		return query.getResultList();
		
	}
}