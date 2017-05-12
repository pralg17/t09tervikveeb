package kuznetsovatatjana;

 import org.junit.runner.RunWith;
 import static org.junit.Assert.*;
 import org.junit.Test;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
 import org.springframework.boot.test.web.client.TestRestTemplate;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RakendusApplicationTests {

    @Autowired
	private Rakendus rakendus;

	@Test
	public void sisenditest(){
//		Rakendus rakendus=new Rakendus();
		String vastus=rakendus.lisamine("", "");
		assertEquals("tyhi sisend", vastus);
//		assertEquals("sisend puudub", rakendus.lisamine(null, null));

	}

	/*@Test
	public void hextest(){
		Rakendus rakendus=new Rakendus();
		assertEquals("tyhi sisend", rakendus.hexkood(""));
		assertEquals("sisend puudub", rakendus.hexkood(null));
	}*/
}