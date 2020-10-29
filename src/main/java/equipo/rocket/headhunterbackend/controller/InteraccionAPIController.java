package equipo.rocket.headhunterbackend.controller;

import equipo.rocket.headhunterbackend.model.Interaccion;
import equipo.rocket.headhunterbackend.services.InteraccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author EquipoRocketEci
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping(value = "/interaccion")
public class InteraccionAPIController {
    
    @Autowired
    @Qualifier("interaccionServices")
    InteraccionServices interaccionServices;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postInteraccion(@RequestBody Interaccion interaccion) {
        try {
            interaccionServices.postInteraccion(interaccion);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/byIdeaAndTipo/{idea}/{tipo}")
    public ResponseEntity<?> getInteraccionByIdeaAndTipo(@PathVariable(name="idea") int idea, @PathVariable(name="tipo") String tipo) {
        try {
            return new ResponseEntity<>(interaccionServices.getInteraccionByIdeaAndTipo(idea,tipo), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/byUser/{user}")
    public ResponseEntity<?> getInteraccionByUser(@PathVariable(name="user") String user) {
        try {
            return new ResponseEntity<>(interaccionServices.getInteraccionByUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path="/{interacionId}")
    public ResponseEntity<?> deleteInteraccion(@PathVariable(name="interacionId") int interacionId) {
        try {
            interaccionServices.deleteInteraccion(interacionId);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
