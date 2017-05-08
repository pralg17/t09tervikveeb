package johan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

    @RequestMapping("/ring")
    public String ring(double diameeter){
        Kujundid r1 = new Ring(diameeter);
        return "Ringi pindala on "+ r1.KujundiPindala();

    }

    @RequestMapping("/koonus")
    public String koonus(double diameeter, double k6rgus){
        Koonus s1 = new Koonus(diameeter, k6rgus);
        return "Koonuse ruumala on "+ s1.KujundiRuumala();

    }


    public static void main(String[] arg){
		System.getProperties().put("server.port", 4430);
        SpringApplication.run(Rakendus.class, arg);
    }
}