package henri;
 
 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.web.bind.annotation.*;
 
 @SpringBootApplication
 @RestController
 
 public class rakendus{
 
     @RequestMapping("/pindala")
     public String pindala(double esimenekulg, double teinekulg){
         pindala p1 = new pindala(esimenekulg, teinekulg);
         return "Pindala on "+ p1.ristkulikuPindala();
 
     }
 
     @RequestMapping("/umbermoot")
     public String umbermoot(double esimenekulg, double teinekulg){
         umbermoot u1 = new umbermoot(esimenekulg, teinekulg);
         return "Umbermoot on "+ u1.ristkulikuUmbermoot();
 
     }
 
 
     public static void main(String[] arg){
 		System.getProperties().put("server.port", 4222);
         SpringApplication.run(rakendus.class, arg);
     }
 }