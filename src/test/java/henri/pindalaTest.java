package henri;
 
 import org.junit.*;
 import static org.junit.Assert.*;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.junit4.SpringRunner;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
 import org.springframework.boot.test.web.client.TestRestTemplate;
 
 
 @RunWith(SpringRunner.class)
 @SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
 
 public class pindalaTest{
     @Autowired
     private TestRestTemplate restTemplate;
 
     @Test
     public void pindala1(){
         String vastus = this.restTemplate.getForObject("/pindala?esimenekulg=5&teinekulg=4",String.class);
 
         assertEquals("Pindala on ",vastus.substring(0, 11));
         assertEquals(20, Double.parseDouble(vastus.substring(11)),0.1);
     }
 }