package karolmilaine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Rakendus{

  @RequestMapping("/circle")
  public String ring(double radius){
    Shapes r1 = new Circle(radius);
    return "Ringi pindala on "+ r1.shapeArea();

  }

  @RequestMapping("/cone")
  public String circle(double radius, double height){
    Cone s1 = new Cone(radius, height);
    return "Silindri ruumala on "+ s1.shapeArea();

  }


  public static void main(String[] arg){
    SpringApplication.run(Rakendus.class, arg);
  }
}
