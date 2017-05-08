package johan;

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

public class RingiTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ymberm66t(){
        String vastus = this.restTemplate.getForObject("/ring?diameeter=8",String.class);

        assertEquals("Ringi pindala on ",vastus.substring(0, 17));
        assertEquals(50.3, Double.parseDouble(vastus.substring(17)),0.1);
    }
}