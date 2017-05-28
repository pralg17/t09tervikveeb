package heino;
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
public class RakendusTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
    public void toiduLisamine(){
	   assertEquals("Lisatud Kartulisalat Salat hinnaga 2.0 euri ", this.restTemplate.getForObject("/lisa?toidu_nimetus=Kartulisalat&toidu_tyyp=Salat&hind=2", String.class));
//getForObject - URLi andmine
    }


		//Vahemiku otsimise testimine
	@Test
    public void otsimineVahemikust(){
	   assertEquals("<tr><th>Id</th><th>Nimetus</th><th>Tüüp</th><th>Hind</th></tr><tr><td>7</td><td>Kapsasupp</td><td>Supp</td><td>1.8</td><td>",
		 this.restTemplate.getForObject("/hinnavahemik?hind_min=1&hind_max=2", String.class));

    }

/*
		@Test
    public void kustutamineAndmebaasist(){
      //assertEquals("kartul  on kustutatud", this.restTemplate.getForObject("/kustuta?id=88" , String.class));
			assertEquals("Antud id-ga toiduainet ei leidu", this.restTemplate.getForObject("/kustuta?id=1" , String.class));
    }
*/
}
