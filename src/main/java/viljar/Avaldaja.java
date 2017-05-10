package viljar;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Avaldaja {

  @RequestMapping("/omahind")
    String Omahind(String anum, String mark ){
      return new Hinnaleidja().Hinnaleidja(anum,mark);
    }
  @RequestMapping("/pudelisse")
    String Pudelisse(String anum, String mark, String kogus )throws IOException {
      return new JookPudelisse().JookPudelisse(anum,mark,kogus);
    }
  @RequestMapping("/koikpudelisse")
    String koik(String anum, String mark )throws IOException {
      return new KoikPudelisse().KoikPudelisse(anum,mark);
    }
  @RequestMapping("/kastimassjaomahind")
    String ko(String anum, String mark, String tuup){
      return new KastiMassJaOmahind().KastiMassJaOmahind(tuup,anum,mark);
    }
    @RequestMapping("/koikkasti")
      String koikkasti(String anum, String mark, String tuup){
        return new VaadistKasti().VaadistKasti(anum,mark,tuup);
}
public static void main(String[] args)throws IOException{
  System.getProperties().put("server.port", 2497);
  SpringApplication.run(Avaldaja.class, args);
}
}
