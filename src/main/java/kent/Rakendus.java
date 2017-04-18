package kent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

  @RequestMapping("/ring")
  public String ring(double raadius){
    Kujundid r1 = new Ring(raadius);
    return "Ringi pindala on "+ r1.KujundiPindala();

  }

  @RequestMapping("/silinder")
  public String ring(double raadius, double korgus){
    Silinder s1 = new Silinder(raadius, korgus);
    return "Silindri ruumala on "+ s1.KujundiPindala();

  }

  @RequestMapping("/kera")
  public String kera(double raadius){
    Kera k1 = new Kera(raadius);
    return "Kera ruumala on "+ k1.KujundiRuumala();

  }

  public static void main(String[] arg){
    SpringApplication.run(Rakendus.class, arg);
  }
}
