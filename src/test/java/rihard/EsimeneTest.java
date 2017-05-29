package rihard;

import org.junit.*;
import static org.junit.Assert.*;


public class EsimeneTest{

	

	
	@Test
	public void test1(){
		
		Rakendus r=new Rakendus();
		assertEquals("S = 6.0", r.vabaliige(3, 2));
		
	}
	
}	
