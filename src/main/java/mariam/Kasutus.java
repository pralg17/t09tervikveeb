package mariam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@SpringBootApplication
public class Kasutus{
	String vastus;

	@RequestMapping("/dollarEuroks")
	public String dEuroks(double x){
		
		Euroks yks = new Euroks();
		vastus = String.valueOf(yks.dollarEuroks(x));
		return vastus;
	}
	@RequestMapping("/rubladEuroks")
	public String rEuroks(double x){
		Euroks yks = new Euroks();
		vastus = String.valueOf(yks.rublaEuroks(x));
		return vastus;
	}
	
	@RequestMapping("/rubladDollariks")
	public String rDollariks(double x){
		Dollariks yks = new Dollariks();
		vastus = String.valueOf(yks.rublaDollariks(x));
		return vastus;
	}
	
	@RequestMapping("/eurodDollariks")
	public String eDollariks(double x){
		Dollariks yks = new Dollariks();
		vastus = String.valueOf(yks.eurodDollariks(x));
		return vastus;
	}
	
	@RequestMapping("/eurodRublaks")
	public String eRublaks(double x){
		Rublaks yks = new Rublaks();
		vastus = String.valueOf(yks.eurodRublaks(x));
		return vastus;
	}
	
	@RequestMapping("/dollarRublaks")
	public String dRublaks(double x){
		Rublaks yks = new Rublaks();
		vastus = String.valueOf(yks.dollaridRublaks(x));
		return vastus;
	}
	
	
	
	
	public static void main (String[] args){
		/*Euroks yks = new Euroks();
		Dollariks kaks = new Dollariks();
		Rublaks kolm = new Rublaks();
		
		
		System.out.println(yks.dollarEuroks(4.0));
		System.out.println(kaks.eurodDollariks(4.0));
		System.out.println(kolm.eurodRublaks(4.0));
		System.out.println(yks.rublaEuroks(400.0));
		System.out.println(kolm.dollaridRublaks(5.0));
		System.out.println(kaks.rublaDollariks(500.0));*/
		
		System.getProperties().put("server.port", 43201);
		SpringApplication.run(Kasutus.class);
		
		
	}
}
//scl enable rh-maven33 bash
//mvn package
//java -jar target/testimine-1.jar