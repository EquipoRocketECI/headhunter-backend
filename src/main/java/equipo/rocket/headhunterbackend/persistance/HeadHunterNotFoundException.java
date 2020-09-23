package equipo.rocket.headhunterbackend.persistance;

import java.util.Set;

public class HeadHunterNotFoundException extends Exception {
    
     private static final long serialVersionUID = 1L;

    public HeadHunterNotFoundException(String message) {
        super(message);
    }

    public HeadHunterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}