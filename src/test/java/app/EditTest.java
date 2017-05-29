package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class EditTest{
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void editTest(){
		
		assertEquals("Edited!", this.restTemplate.getForObject("/edit?artist=Picasso&painting=a&genre=b", String.class));
		
	}
	
	@Test
	public void editTest2(){
		
		assertEquals("Artist not found!", this.restTemplate.getForObject("/edit?artist=Pic&painting=a&genre=b", String.class));
		
	}
	
	/*public void editTest3(){
		
		assertEquals("Edited!", this.restTemplate.getForObject("/edit?artist=Pic&painting=a&genre=b", String.class));
		
	}*/
	
}