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

public class KoonuseTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ruumala(){
        String vastus = this.restTemplate.getForObject("/koonus?diameeter=2&k6rgus=5",String.class);
		
        assertEquals("Koonuse ruumala on ",vastus.substring(0, 19));
        assertEquals(7.8, Double.parseDouble(vastus.substring(19)),0.1);
    }
}
