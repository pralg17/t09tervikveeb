package Johan;
 
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
         String vastus = this.restTemplate.getForObject("/pindala?raadius=5&korgus=4",String.class);
 
         assertEquals("Silindri ruumala on ",vastus.substring(0, 20));
         assertEquals(314.16, Double.parseDouble(vastus.substring(20)),0.2);
     }
 }