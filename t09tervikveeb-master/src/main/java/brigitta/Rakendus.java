package brigitta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

  @RequestMapping("/ring")
  public String ring(double raadius){
    Kujundid r1 = new Ring(raadius);
    return "Ringi pindala on "+ r1.kujundiPindala();

  }

  @RequestMapping("/silinder")
  public String ring(double raadius, double k6rgus){
    Silinder s1 = new Silinder(raadius, k6rgus);
    return "Silindri ruumala on "+ s1.kujundiRuumala();

  }


  public static void main(String[] arg){
    SpringApplication.run(Rakendus.class, arg);
  }
}
