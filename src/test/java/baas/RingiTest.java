package baas;

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
    public void perimeter(){
        String answer = this.restTemplate.getForObject("/ringipindala?radius=4",String.class);

        assertEquals("Ringi pindala on ",answer.substring(0, 17));
        assertEquals(50.2, Double.parseDouble(answer.substring(17)),0.1);
    }
}