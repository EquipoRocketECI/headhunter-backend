/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.controller;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.services.*;

import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author EquipoRocketEci
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping(value = "/usuario")
public class UsuarioAPIController {
 @Autowired
	  @Qualifier("UsuarioServices")
	  UsuarioServices user;
	  
	  @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<?> getAllUser(){
	        try{
	            return new ResponseEntity<>(user.getAllUsers(),HttpStatus.ACCEPTED);
	        }catch (Exception ex){
	        	Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	  

	    
	    @RequestMapping(path = "/{correo}", method = RequestMethod.GET)
	    public ResponseEntity<?> getUsuario(@PathVariable(name = "correo") String correo) {
	        try {
	            Usuario usuario = user.getUsuario(correo);
	            return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);

	        } catch (Exception ex) {
	        	ex.printStackTrace(System.out);
	            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    
	    @RequestMapping(path = "/getNombreCompleto/{correo}", method = RequestMethod.GET)
	    public ResponseEntity<?> getNombreCompleto(@PathVariable(name = "correo") String correo) {
	        try {
	            String nombrecompleto = user.getNombreCompleto(correo);
	            return new ResponseEntity<>(nombrecompleto, HttpStatus.ACCEPTED);

	        } catch (Exception ex) {
	        	ex.printStackTrace(System.out);
	            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
	        }
	    }

		 @RequestMapping(method = RequestMethod.POST)	
	    public ResponseEntity<?> manejadorPostRecursoUsuario(@RequestBody Usuario usuario){
	        
	        try {
	            user.addUser(usuario);
	            return new ResponseEntity<>(HttpStatus.CREATED);
	        } catch (Exception ex) {
	            Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	        }        

	    }

		 @RequestMapping(path = "/{correo}/contrasena/{contrasena}",method = RequestMethod.PUT)	
		    public ResponseEntity<?> putPassword(@PathVariable ("correo") String correo,@PathVariable ("contrasena") String  contrasena){
		        
		        try {
		            user.changePassword(correo, contrasena);
		            return new ResponseEntity<>(HttpStatus.ACCEPTED);
		        } catch (Exception ex) {
		            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
		            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
		        }
		    
		    }
		 
		 @RequestMapping(path = "/{correo}/nombrecompleto/{nombrecompleto}",method = RequestMethod.PUT)	
		    public ResponseEntity<?> putNombreCompleto(@PathVariable ("correo") String correo,@PathVariable ("nombrecompleto") String  nombrecompleto){
		        
		        try {
		            user.changeNombreCompleto(correo, nombrecompleto);
		            return new ResponseEntity<>(HttpStatus.ACCEPTED);
		        } catch (Exception ex) {
		            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
		            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
		        }
		    
		    }
	    }
	        
    

