package matu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Rakendus{
	
	//http://greeny.cs.tlu.ee:4207/KeraRuumala?raadius=5&konstant=0.333333
	@RequestMapping("/KeraRuumala")
	public String KeraRuumala(double raadius, double konstant) {
		Kera s1 = new Kera(raadius, konstant);
		return "Kera ruumala on " + s1.keraruumala()*5;
	}
	
	public static void main(String[] arg) {
		SpringApplication.run(Rakendus.class, arg);
	}
}