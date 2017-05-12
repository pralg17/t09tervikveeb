package kuznetsovatatjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {
	
    @Autowired
    private VarviHaldur haldur;
    
    @RequestMapping("/otsimine")
   	public String otsimine(String nimi){
   	   Varvid varv=haldur.findOne(nimi);
   	   return "Värvi nimetus on "+nimi+" ja selle hex kood on  " + varv.hexkood;
   	}

    @RequestMapping("/lisamine")
	public String lisamine(String nimi, String hexkood) {
            Varvid varv = new Varvid();
            varv.nimi = nimi;
            varv.hexkood = hexkood;
			System.out.println(haldur);
            haldur.save(varv); 
    return "tyhi sisend";
	}

    @RequestMapping("/kustutaminne")
    public String kustutamine(String nimi) {
            Varvid varv=haldur.findOne(nimi);
            haldur.delete(varv);
        return "Kustutatud värvi nimetus on " +varv.nimi + " ja selle Hex kood on " + varv.hexkood;
    }

    public static void main(String[] args) {
		System.getProperties().put("server.port", 5678);
        SpringApplication.run(Rakendus.class);
    }
}
