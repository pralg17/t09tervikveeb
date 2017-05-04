package edgar;

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
public class TetraedrTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
	public void pindalaTest(){
    Kujundid k3=new Kolmnurk(5);
		assertEquals(43.30127018922193, k3.TetraedriPindala(), 1);
    
	}
	
	@Test
	public void ruumalaTest(){
    Kujundid k3=new Tetraedr(5);
		assertEquals(14.73139127471974, k3.TetraedriRuumala(), 1);
	}
}