package ksenbelo;

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

public class kolmnurkTest{
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void pindala2(){
	String tulemus = this.restTemplate.getForObject("/pindala?a=2&b=3&c=4",String.class);
		
	assertEquals("Kolmnurka pindala on",tulemus.substring(0,20));
	assertEquals(9.0, Double.parseDouble(tulemus.substring(20)),0.1);		
	}
}