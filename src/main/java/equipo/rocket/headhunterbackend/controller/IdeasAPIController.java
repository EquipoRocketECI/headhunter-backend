package equipo.rocket.headhunterbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import equipo.rocket.headhunterbackend.services.IdeaServices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import equipo.rocket.headhunterbackend.model.ExpertosRequeridos;
import equipo.rocket.headhunterbackend.model.Idea;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
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

    @RequestMapping(path = "/filtered",method = RequestMethod.POST)
    public ResponseEntity<?> filter(@RequestBody HashMap<String,Object> extraParams){
        try {//ver si se puede mapear directamente a hashmap desde json
            return new ResponseEntity<>(is.filter(extraParams),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> postIdeas(@RequestBody Idea idea){
        try {
        	
            return new ResponseEntity<>(is.addIdea(idea),HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }
    }
    
    @RequestMapping(path = "/{idea}", method = RequestMethod.GET)
    public ResponseEntity<?> getIdeaByID(@PathVariable(name = "idea") int idIdea) {
        try {
 
            Idea idea = is.getIdeaByID(idIdea);
            return new ResponseEntity<>(idea, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.PUT)	
    public ResponseEntity<?> PutIdea(@PathVariable ("id") int id,@RequestBody Idea idea ){
        try {          
            is.putIdea(idea);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(path = "/{id}/donacion/{donacion}",method = RequestMethod.PUT)	
    public ResponseEntity<?> donar(@PathVariable ("id") int id,@PathVariable ("donacion") int donacion ){
        
        try {
            is.addMonto(id, donacion);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    
    }
    
    
    @RequestMapping(path = "/expertos", method = RequestMethod.POST)	
    public ResponseEntity<?> postExpertos(@RequestBody ExpertosRequeridos expReq){
        try {
        	is.postExpert(expReq);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }
    }
    
    
    @RequestMapping(path = "/{idea}/expertos", method = RequestMethod.GET)
    public ResponseEntity<?> getExpertosByIdea(@PathVariable(name = "idea") int idIdea) {
        try {
        	List<ExpertosRequeridos> expReqs = is.getExpertsByIdea(idIdea);
            return new ResponseEntity<>(expReqs, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}