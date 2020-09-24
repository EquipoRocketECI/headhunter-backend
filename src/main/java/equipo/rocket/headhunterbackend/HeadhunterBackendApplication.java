package equipo.rocket.headhunterbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"equipo.rocket.headhunterbackend"})
public class HeadhunterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeadhunterBackendApplication.class, args);
		
	}

}
