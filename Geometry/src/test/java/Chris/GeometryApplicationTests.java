package Chris;

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
public class GeometryApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void CircleTest() {
		assertEquals("Area: 254.0"+"<br>"+"Perimeter: 57.0", this.restTemplate.getForObject("/Circle?radius=9", String.class));
	}
	
	@Test
	public void RectangleTest(){
		assertEquals("Area: 42.0"+"<br>"+"Perimeter: 26.0", this.restTemplate.getForObject("/Rectangle?height=6&width=7", String.class));
	}
	
	@Test
	public void TriangleTest(){
		assertEquals("Area: 6.0"+"<br>"+"Perimeter: 12.0", this.restTemplate.getForObject("/Triangle?side1=3&side2=4&side3=5", String.class));
	}

}
