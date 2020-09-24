/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services.impl;

import equipo.rocket.headhunterbackend.model.Idea;

import java.util.List;

import equipo.rocket.headhunterbackend.services.*;
import equipo.rocket.headhunterbackend.persistance.HeadHunterNotFoundException;
import equipo.rocket.headhunterbackend.persistance.IdeasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author EquipoRocketEci
 */
@Service("ideaServices")
public class IdeaServicesImpl implements IdeaServices{
    
    @Autowired
    IdeasRepository idp;
    
    @Override
    public List<Idea> getAllIdeas() throws Exception{
        return idp.getAllIdeas();
    }
    
    @Override
     public void addIdea(Idea idea){
        idp.postIdea(idea);
     }

	@Override
	public Idea getIdeaByID(int idIdea)  throws  HeadHunterNotFoundException{
		try{
            Idea idea = idp.findById(idIdea).get();
            return idea;
        }
        catch(java.util.NoSuchElementException e){
           throw new HeadHunterNotFoundException("No existe la idea");
        } 
	
	}

}
