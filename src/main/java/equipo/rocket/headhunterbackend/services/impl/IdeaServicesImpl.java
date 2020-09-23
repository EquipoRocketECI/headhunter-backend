/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo.rocket.headhunterbackend.services.impl;

import java.util.Set;
import equipo.rocket.headhunterbackend.services.*;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author EquipoRocketEci
 */
@Service("ideaServices")
public class IdeaServicesImpl implements IdeaServices{
    
    @Autowired
    IdeasPersistance idp =null;

    public Set<Idea> getAllIdeas() throws Exception{
        return idp.getAllIdeas();
    }
    
     public Idea addIdea(Idea idea){
         return idp.postIdea(idea);
     }
    
}
