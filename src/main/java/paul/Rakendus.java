package paul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Rakendus{

	@RequestMapping("/PyramiidiRuumala")
	public String PyramiidiRuumala(double k6rgus, double alus) {
		Pyramiid s1 = new Pyramiid(alus, k6rgus);
		return "Pyramiidi ruumala on " + s1.pyramiidiRuumala();
	}

	public static void main(String[] arg) {
		SpringApplication.run(Rakendus.class, arg);
	}
}