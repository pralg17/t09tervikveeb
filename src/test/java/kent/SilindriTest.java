package kent;

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
public class SilindriTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ruumala1(){
        String vastus = this.restTemplate.getForObject("/silinder?raadius=2&korgus=5",String.class);

        assertEquals("Silindri ruumala on ",vastus.substring(0, 20));
        assertEquals(78.5, Double.parseDouble(vastus.substring(20)),0.1);
    }
}
