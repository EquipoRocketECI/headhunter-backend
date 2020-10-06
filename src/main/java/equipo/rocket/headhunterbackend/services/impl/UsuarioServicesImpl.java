/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.services.UsuarioServices;
import equipo.rocket.headhunterbackend.persistance.exceptions.HeadHunterNotFoundException;
import equipo.rocket.headhunterbackend.persistance.exceptions.HeadHunterPersistanceException;
import equipo.rocket.headhunterbackend.persistance.repositories.UsuarioRepository;

/**
 *
 * @author EquipoRocketEci
 */
@Service("UsuarioServices")
public class UsuarioServicesImpl implements UsuarioServices{

@Autowired
	private UsuarioRepository userRepo;
	
	 @Autowired
	 @Qualifier("AuctionCacheImpl")
	
	  @Override
	    public List<Usuario> getAllUsers(){
	        return userRepo.findAll(); 
	    }

	@Override
	    public Usuario getUsuario(String correo) throws HeadHunterNotFoundException{
	        try{
	            Usuario user = userRepo.findById(correo).get();
	            return user;
	        }
	        catch(java.util.NoSuchElementException e){
	           throw new HeadHunterNotFoundException("No existe el usuario");
	        }
				           
	    }

		@Override
	public Usuario addUser(Usuario user) throws HeadHunterPersistanceException {
		try {
            Usuario u = getUsuario(user.getCorreo());
            throw new HeadHunterPersistanceException("Nombre de usuario ya tomado");
        }
        catch(HeadHunterNotFoundException ce){

            return userRepo.saveAndFlush(user);
        }
	}

	

	@Override
	public String getNombreCompleto(String correo) {
		return userRepo.getNombreCompleto(correo).get(0).getNombrecompleto();
	}
    
}
