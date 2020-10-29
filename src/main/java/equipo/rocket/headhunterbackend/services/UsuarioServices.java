/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services;

import java.util.List;

import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.*;
import equipo.rocket.headhunterbackend.persistance.exceptions.HeadHunterNotFoundException;
import equipo.rocket.headhunterbackend.persistance.exceptions.HeadHunterPersistanceException;
/**
 *
 * @author EquipoRocketEci
 */
public interface UsuarioServices {

public List<Usuario> getAllUsers();
	
	public Usuario getUsuario(String correo) throws HeadHunterNotFoundException;
	
	public Usuario addUser(Usuario user) throws HeadHunterPersistanceException;


    public String getNombreCompleto(String correo);

	public void changePassword(String correo, String contrasena) throws HeadHunterNotFoundException;

	public void changeNombreCompleto(String correo, String nombrecompleto) throws HeadHunterNotFoundException;
    
}
