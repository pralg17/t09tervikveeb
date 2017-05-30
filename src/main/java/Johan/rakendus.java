package Johan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class rakendus{

	@RequestMapping("/silinder")
	public String ruumala(double korgus, double raadius) {
		silinder s1 = new silinder(korgus, raadius);
		return "Silindri ruumala on " + s1.silindriRuumala();
	}

	public static void main(String[] arg) {
            System.getProperties().put("server.port", 4220);
		SpringApplication.run(rakendus.class, arg);
	}
}
//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar