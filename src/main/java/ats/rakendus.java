package ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class rakendus{

	@RequestMapping("/pyramiid")
	public String pyramiid(double alus, double korgus, double kKorgus){
		pyramiid p3 = new pyramiid(alus, korgus, kKorgus);
		return "Pyramiidi ruumala ja kuljepindala on " + p3.ruumala() + " ja " + p3.kuljePindala();
	}
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4258);
        SpringApplication.run(rakendus.class, args);
    }
}
//scl enable rh-maven33 bash
//mvn package
//mvn test
//java -jar target/app-1.jar
//http://localhost:5554/pyramiid?alus=2&korgus=3&kKorgus=3
