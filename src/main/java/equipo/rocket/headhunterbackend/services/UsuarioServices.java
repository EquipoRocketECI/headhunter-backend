/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services;

import java.util.List;

import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.*;
/**
 *
 * @author EquipoRocketEci
 */
public interface UsuarioServices {

public List<Usuario> getAllUsers();
	
	public Usuario getUsuario(String correo) throws HeadHunterNotFoundException;
	
	public Usuario addUser(Usuario user) throws HeadHunterPersistanceException;


    public String getNombreCompleto(String correo);
    
}
