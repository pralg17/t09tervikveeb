package tanel;

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
public class keskmiseltAktiivseTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void keskmiseltAktiivne(){
        String vastus= this.restTemplate.getForObject("/keskmineAktiivne?kaal=50&pikkus=150&vanus=21",String.class);

        assertEquals("Keskmiselt aktiivse kalorivajadus: ",vastus.substring(0,35));
        assertEquals(2330.7, Double.parseDouble(vastus.substring(35)),0.2);
    }
}