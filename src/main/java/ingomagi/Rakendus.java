package ingomagi;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {

	@RequestMapping("/ruut")
	String ruut(String ruut){
        try{
            double Arv = Double.parseDouble(ruut);
           return "Arvu ruut on: "+String.valueOf(Math.pow(Arv, 2));
       } catch (Exception e){
            return "Viga: "+e.getMessage();
        }
   }
	@RequestMapping("/ringpindala")
	String proov(Double raadius){
		try{
		klass ring1=new ring(raadius);
		System.out.println("ringi pindala : "+Math.round(ring1.pindala()));
		return "ringi pindala on: "+String.valueOf(Math.round(ring1.pindala()));
		}catch (Exception e){
		return "Viga: "+e.getMessage();}
	} 
	@RequestMapping("/ringumbermoot")
	String proov2(Double raadius){
		try{
		klass ring1=new ring(raadius);
		System.out.println("ümbermõõt on: "+ Math.round(ring1.umbermoot()));
		return "ringi ümbermõõt on: "+String.valueOf(Math.round(ring1.umbermoot()));
		}catch (Exception e){
		return "Viga: "+e.getMessage();}
	} 
	@RequestMapping("/ruuduubermoot")
	String proov3(Double kylg){
		try{
		klass ruut1=new ruut(kylg);
		System.out.println("ruudu ümbermõõt on "+ruut1.umbermoot()+ " ja pindala on: "+ruut1.pindala());
		return "Ruudu ümbermõõt on: "+String.valueOf(Math.round(ruut1.umbermoot()));
		}catch (Exception e){
		return "Viga: "+e.getMessage();}
	}
 
    public static void main(String[] args) {
		System.getProperties().put("server.port", 5501);
        SpringApplication.run(Rakendus.class, args);
    }
}	

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar