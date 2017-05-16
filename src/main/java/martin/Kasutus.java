package martin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@SpringBootApplication
public class Kasutus{
	String vastus;

	@RequestMapping("/FarenCelsius")
	public String fCelsius(double x){
		
		Celsius yhik = new Celsius();
		vastus = String.valueOf(yhik.FarenCelsius(x));
		return vastus;
	}
	@RequestMapping("/KelvinCelsius")
	public String kCelsius(double x){
		Celsius yhik = new Celsius();
		vastus = String.valueOf(yhik.KelvinCelsius(x));
		return vastus;
	}
	
	@RequestMapping("/CelsiusFaren")
	public String cFaren(double x){
		Faren yhik = new Faren();
		vastus = String.valueOf(yhik.CelsiusFaren(x));
		return vastus;
	}
	
	@RequestMapping("/KelvinFaren")
	public String kFaren(double x){
		Faren yhik = new Faren();
		vastus = String.valueOf(yhik.KelvinFaren(x));
		return vastus;
	}
	
	@RequestMapping("/CelsiusKelvin")
	public String cKelvin(double x){
		Kelvin yhik = new Kelvin();
		vastus = String.valueOf(yhik.CelsiusKelvin(x));
		return vastus;
	}
	
	@RequestMapping("/FarenKelvin")
	public String fKelvin(double x){
		Kelvin yhik = new Kelvin();
		vastus = String.valueOf(yhik.FarenKelvin(x));
		return vastus;
	}
	
	
	public static void main (String[] args){
		System.getProperties().put("server.port", 2456);
		SpringApplication.run(Kasutus.class);
		
		
	}
}
//scl enable rh-maven33 bash
//mvn package
//java -jar target/t09tervikveeb-1.jar