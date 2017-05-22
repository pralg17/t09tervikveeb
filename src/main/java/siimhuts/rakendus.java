package siimhuts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class rakendus{

	@RequestMapping("/pyramiid")
	public String pyramiid(double alus, double korgus, double kKorgus){
		pyramiid p3 = new pyramiid(alus, korgus, kKorgus);
		return "Pyramiidi ruumala ja kuljepindala on " + p3.ruumala() + "ja" + p3.kuljePindala();
	}
	public static void main(String [] arg){
		SpringApplication.run(rakendus.class, arg);
	}
}
//scl enable rh-maven33 bash
//mvn package
//java -Dserver.port=4545 -jar target/app1.jar
//http://greeny.cs.tlu.ee:4545/tervita?eesnimi=Juku
