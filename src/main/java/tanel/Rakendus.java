package tanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication
public class Rakendus{
	

	public static double arvuta(JooneVorrand2 fn, double arv1, double arv2){
		
		return fn.f(arv1, arv2);
		
	}

	
	@RequestMapping("/joon2")
	public String vabaliige(double a, double b){
	
		JooneVorrand2 vabaliige=new Joonefunktsioon2(a, b);

		return "S = "+(arvuta(vabaliige, a, b));
		
	}
	


	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 8768);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar