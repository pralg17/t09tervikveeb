package brigitta;

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
        String answer = this.restTemplate.getForObject("/ring?raadius=3",String.class);

        assertEquals("Ringi pindala on ",answer.substring(0, 17));
        assertEquals(28.2, Double.parseDouble(answer.substring(17)),0.1);
    }
}
