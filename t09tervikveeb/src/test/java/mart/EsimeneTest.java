package mart;

import org.junit.*;
import static org.junit.Assert.*;


public class EsimeneTest{
	@Test
	public void test1(){
		assertEquals("Esimene","Esimene");
	}
	@Test
	public void test2(){
		final double DELTA = 1e-15;
		Inimene testin1 = new Inimene(70, 150);
		float expectedResult=154.0f;
		assertEquals(expectedResult, testin1.lbs(),DELTA);
	}	
}	