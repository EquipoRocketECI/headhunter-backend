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

@RestController
@RequestMapping(value = "/idea")
public class IdeasAPIController {

    @Autowired
    @Qualifier("ideaServices")
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
            return new ResponseEntity<>(is.addIdea(Idea),HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear el nuevo tiquete",HttpStatus.FORBIDDEN);            
        }
    }

}