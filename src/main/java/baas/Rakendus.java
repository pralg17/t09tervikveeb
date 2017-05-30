package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

  @RequestMapping("/ringipindala")
  public String ring(double radius){
    Kujundid r1 = new Ring(radius);
    return "Ringi pindala on "+ r1.kujundiPindala();

  }

  @RequestMapping("/koonus")
  public String ring(double radius, double height){
    Koonus s1 = new Koonus(radius, height);
    return "Koonuse ruumala on "+ s1.kujundiPindala();

  }


  public static void main(String[] arg){
	System.getProperties().put("server.port", 1719);
    SpringApplication.run(Rakendus.class, arg);
  }
}


/*
scl enable rh-maven33 bash
mvn package
java -jar target/baas-1.jar
*/