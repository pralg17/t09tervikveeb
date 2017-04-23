package edgar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

  @RequestMapping("/kolünurk")
  public String kolmnurk(double pikkus){
    Kujundid kolmnurk1 = new Kolmnurk(pikkus);
    return "Tetraedri pindala on "+ kolmnurk1.TetraedriPindala() + "ruudus";

  }

  @RequestMapping("/tetraedr")
  public String tetraedr(double a){
    Kujundid kolmnurk2 = new Tetraedr(a);
    return "Tetraedri ruumala on "+ kolmnurk2.TetraedriRuumala() + "kuubis";

  }

  public static void main(String[] arg){
    SpringApplication.run(Rakendus.class, arg);
  }
}


//scl enable rh-maven33 bash
//mvn package
//java -Dserver.port=42222 -jar target/app1.jar

/* Tetraedri pindala on 15.588457268119894 ruudus */

/*Tetraedri ruumala on 3.1819805153394642 */