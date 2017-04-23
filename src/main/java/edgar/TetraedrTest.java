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
    public void ruumala2(){
        String vastus = this.restTemplate.getForObject("/tetraedr?pikkus=5",String.class);

        assertEquals("Tetraedri ruumala on ",vastus.substring(0, 16));
        assertEquals(84.8, Double.parseDouble(vastus.substring(16)),0.1);
    }
}