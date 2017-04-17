package matu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Rakendus{
	
	@RequestMapping("/KeraRuumala")
	public String KeraRuumala(double raadius, double konstant) {
		Kera s1 = new Kera(raadius, konstant);
		return "Kera ruumala on " + s1.keraruumala()*5;
	}
	
	public static void main(String[] arg) {
		SpringApplication.run(Rakendus.class, arg);
	}
}