package karlerik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class Rakendus {
	
	@RequestMapping("/shoppingcart")
	
	String shoppingCart(String products) {
		
		Tooted ostukorv = new Tooted(products);
		return ostukorv.toString();
	}

	
	public static void main(String[] args) {
		
		System.getProperties().put("server.port", 4221);
		SpringApplication.run(Rakendus.class, args);
	}
	
}