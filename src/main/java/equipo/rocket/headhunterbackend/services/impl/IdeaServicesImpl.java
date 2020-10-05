/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services.impl;

import equipo.rocket.headhunterbackend.model.Idea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import equipo.rocket.headhunterbackend.services.*;
import equipo.rocket.headhunterbackend.services.filters.CalificacionFilter;
import equipo.rocket.headhunterbackend.services.filters.CategoriaFilter;
import equipo.rocket.headhunterbackend.services.filters.FilterChain;
import equipo.rocket.headhunterbackend.services.filters.InvestmentFilter;
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
        return ir.findAll();
    }

    @Override
    public void addIdea(Idea idea) {
        ir.postIdea(idea);
    }

    @Override
    public List<Idea> filter(HashMap<String, Object> extraParams) {
        List<Idea> ideas = new ArrayList<Idea>(ir.findAll());
        FilterChain filterChain = new CategoriaFilter();
        FilterChain investmentFilter = new InvestmentFilter();
        filterChain.setNextFilter(investmentFilter);
        investmentFilter.setNextFilter(new CalificacionFilter());
        filterChain.filter(ideas, extraParams);
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

}
