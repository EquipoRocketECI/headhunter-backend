package equipo.rocket.headhunterbackend.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import equipo.rocket.headhunterbackend.services.IdeaServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import equipo.rocket.headhunterbackend.model.Idea;

@RestController
@RequestMapping(value = "/ideas")
public class IdeasAPIController {

    @Autowired
    IdeaServices is;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllIdeas() {
        try {
            return new ResponseEntity<>(is.getAllIdeas(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> postIdeas(@RequestBody Idea idea){
        try {
            return new ResponseEntity<>(is.addIdea(idea),HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear el nuevo tiquete",HttpStatus.FORBIDDEN);            
        }
    }

}