package mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Wingload {

	@RequestMapping("/inimene3Wl")  
    String tervitusfunktsioon() {
		
		Inimene inimene3=new Inimene(65.0, 140.0);
         return "Wingload1 on: "+inimene3.lbs()/inimene3.ruutjalad;	
     }
	
	@RequestMapping("/inimene2Lbs")  
    String tervitusfunktsioon2() {
		
		Inimene inimene2=new Inimene(60.0, 135.0);
         return "Kui lbs oleks kg siis mu kaal oleks nii suur: "+inimene2.lbs();
	}
	
    @RequestMapping("/inimene1Wl")  
    String tervitusfunktsioon3() {

		Inimene inimene1=new Inimene(70.0, 150.0);        
		return "Wingload1 on: "+inimene1.lbs()/inimene1.ruutjalad;		 
	
	}
    public static void main(String[] args) {
		System.getProperties().put("server.port", 1234);
        SpringApplication.run(Wingload.class, args);
		
		
		
    }
}	

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot1-1.0-SNAPSHOT.jar