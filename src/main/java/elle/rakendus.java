package elle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class rakendus{

    @RequestMapping("/pindala")
    public String pindala(double pikkus, double laius, double korgus){
        kujundid p1 = new pindala(pikkus, laius, korgus);
        return "Pindala on "+ p1.kujundiPindala();

    }

    @RequestMapping("/ruumala")
    public String ruumala(double pikkus, double laius, double korgus){
        ruumala r1 = new ruumala(pikkus, laius, korgus);
        return "Ruumala on "+ r1.kujundiRuumala();

    }


    public static void main(String[] arg){
		System.getProperties().put("server.port", 4022);
        SpringApplication.run(rakendus.class, arg);
    }
}
