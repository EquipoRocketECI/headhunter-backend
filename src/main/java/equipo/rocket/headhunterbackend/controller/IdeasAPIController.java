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
@RequestMapping(value = "/explore")
public class IdeasAPIController {

    @Autowired
    IdeaServices is = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllIdeas() {
        try {
            return new ResponseEntity<>(is.getAllIdeas(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(IdeasAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}