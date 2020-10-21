/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services.impl;

import equipo.rocket.headhunterbackend.model.ExpertosRequeridos;
import equipo.rocket.headhunterbackend.model.Idea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import equipo.rocket.headhunterbackend.services.*;
import equipo.rocket.headhunterbackend.services.filters.CategoriaFilter;
import equipo.rocket.headhunterbackend.services.filters.FilterChain;
import equipo.rocket.headhunterbackend.persistance.exceptions.HeadHunterNotFoundException;
import equipo.rocket.headhunterbackend.persistance.repositories.IdeasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EquipoRocketEci
 */
@Service("is")
public class IdeaServicesImpl implements IdeaServices {

    @Autowired
    IdeasRepository ir = null;

    @Override
    public List<Idea> getAllIdeas() throws Exception {
        return ir.getAllIdeas();
    }

    @Override
    public Idea addIdea(Idea idea) {
        return ir.postIdea(idea);
    }

    @Override
    public List<Idea> filter(HashMap<String, Object> extraParams) {
        List<Idea> ideas = new ArrayList<Idea>(ir.getAllIdeas());
        FilterChain categoriaFilter = new CategoriaFilter();
        categoriaFilter.filter(ideas, extraParams);
        return ideas;
    }

	@Override
	public Idea getIdeaByID(int idIdea)  throws  HeadHunterNotFoundException{
		try{
            Idea idea = ir.findById(idIdea).get();
            return idea;
        }
        catch(java.util.NoSuchElementException e){
           throw new HeadHunterNotFoundException("No existe la idea");
        } 
	
	}

	@Override
	public void putIdea(Idea idea)  throws  HeadHunterNotFoundException{
		getIdeaByID(idea.getId());
		ir.putIdea(idea);
		
	}

	@Override
	public void addMonto(int idIdea, int donacion)  throws  HeadHunterNotFoundException{
		Idea idea = getIdeaByID(idIdea);
		int newMontoRecolectado = idea.getMontoRecolectado()+donacion;
		ir.addMonto(idIdea, newMontoRecolectado);
	}

	@Override
	public void postExpert(ExpertosRequeridos exp) {
		ir.postExpert(exp);
		
	}

	@Override
	public List<ExpertosRequeridos> getExpertsByIdea(int idIdea)  throws  HeadHunterNotFoundException{
		getIdeaByID(idIdea);
		return ir.getExpertsByIdea(idIdea);
	}
	
	

}
