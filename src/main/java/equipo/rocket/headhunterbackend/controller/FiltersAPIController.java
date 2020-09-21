package equipo.rocket.headhunterbackend.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import equipo.rocket.headhunterbackend.services.ExploreServices;

@RestController
@RequestMapping(value = "/explore")
public class FiltersAPIController{

    @Autowired
    ExploreServices es =null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllIdeas(){
        try {
            return new ResponseEntity<>(es.getAllIdeas(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(FiltersAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}