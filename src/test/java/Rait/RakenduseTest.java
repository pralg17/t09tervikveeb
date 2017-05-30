package Rait;

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

public class RakenduseTest{
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void katse1(){
		assertEquals(3, 2+1);
	}

	@Test
	public void muutmine1(){
		String vastus=this.restTemplate.getForObject(
		  "/muuda", String.class);
		assertEquals("Filmi nimi sisestamata!", vastus);
	}
	
	@Test
	public void muutmine2(){
		String vastus=this.restTemplate.getForObject(
		  "/muuda?nimi=Split", String.class);
		assertEquals("Ebasobiv või puuduv seis!", vastus);
	}
	
	@Test
	public void muutmine3(){
		String vastus=this.restTemplate.getForObject(
		  "/muuda?nimi=Thor&seis=vaatamata", String.class);
		assertEquals("Sellist filmi ei ole andmebaasis!", vastus);
	}
	
	@Test
	public void muutmine4(){
		String vastus=this.restTemplate.getForObject(
		  "/muuda?nimi=Split&seis=ei mäleta", String.class);
		assertEquals("Ebasobiv või puuduv seis!", vastus);
	}
	
	@Test
	public void muutmine5(){
		String vastus=this.restTemplate.getForObject(
		  "/muuda?nimi=Split&seis=pooleli", String.class);
		assertEquals("Muudetud: Split(2016) 117 min - pooleli", vastus);
	}
    
}

/*
Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ t06 ---
[INFO] Building jar: /home/raitkeer/public_html/java/t06veebirakendus2/target/t06-1.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:1.5.2.RELEASE:repackage (default) @ t06 ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8.755 s
[INFO] Finished at: 2017-05-23T17:31:58+03:00
[INFO] Final Memory: 32M/250M
[INFO] ------------------------------------------------------------------------
[raitkeer@greeny t06veebirakendus2]$
*/

