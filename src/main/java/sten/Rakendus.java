package sten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Rakendus{

	@RequestMapping("/SilindriRuumala")
	public String SilindriRuumala(double k6rgus, double raadius) {
		Silinder s1 = new Silinder(raadius, k6rgus);
		return "Pyramiidi ruumala on " + s1.silindriRuumala();
	}

	public static void main(String[] arg) {
		SpringApplication.run(Rakendus.class, arg);
	}
}
