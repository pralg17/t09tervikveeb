package ksenbelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class rakendus{

	@RequestMapping("/pindala")
	public String kolmnurk(double a, double b, double c) {
		kolmnurk k1 = new pindala(a,b,c);
		return "Kolmnurka pindala on " + k1.kolmnurkpindala();
	}

    public static void main(String[] args) {
        SpringApplication.run(rakendus.class, args);
	}
}

//Kolmnurka pindala on 9.0