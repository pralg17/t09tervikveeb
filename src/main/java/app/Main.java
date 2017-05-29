package app;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main{


	Fruit apple = new Fruit("Apple", 1, 3);
	Fruit banana = new Fruit("Banana", 1, 2);
	
	List<Fruit> fruits = new ArrayList<Fruit>(){{
	add(apple);
	add(banana);
	}};

	@RequestMapping("/increment")
	public String increment(String fruit){
		
		for(Fruit f: fruits){
			if(f.getName() == fruit){
				f.increment();
				return f.toString();
			}
		}
		return "error";
	}
	
	@RequestMapping("/sum")
	public String calculateSum(String fruit){
		
		for(Fruit f: fruits){
			if(f.getName() == fruit){
				return "Sum: "+f.sum();
			}
		}
		return "Error";
	}
	
	public static void main(String[] args){
		
		SpringApplication.run(Main.class, args);
	
	}
}