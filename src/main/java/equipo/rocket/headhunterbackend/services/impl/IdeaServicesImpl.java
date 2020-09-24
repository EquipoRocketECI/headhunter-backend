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
import equipo.rocket.headhunterbackend.services.filters.CategoriaFilter;
import equipo.rocket.headhunterbackend.services.filters.FilterChain;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author EquipoRocketEci
 */
@Service("is")
public class IdeaServicesImpl implements IdeaServices {

    @Autowired
    IdeasPersistance idp = null;

    @Override
    public List<Idea> getAllIdeas() throws Exception {
        return idp.getAllIdeas();
    }

    @Override
    public Idea addIdea(Idea idea) {
        return idp.postIdea(idea);
    }

    @Override
    public List<Idea> filter(HashMap<String, Object> extraParams) {
        List<Idea> ideas = new ArrayList<Idea>(idp.getAllIdeas());
        FilterChain categoriaFilter = new CategoriaFilter();
        categoriaFilter.filter(ideas, extraParams);
        return ideas;
    }

}
