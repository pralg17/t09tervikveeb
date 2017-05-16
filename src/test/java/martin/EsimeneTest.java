package martin;

import org.junit.*;
import static org.junit.Assert.*;

public class EsimeneTest{
	@Test
	public void test1(){
		Celsius yks = new Celsius();
		assertEquals(33.8,yks.FarenCelsius(1.0),0.1);
		assertEquals(274.15,yks.KelvinCelsius(1.0),0.1);
	}
	//ok
	@Test
	public void test2(){
		Faren kaks = new Faren();
		assertEquals(-15,kaks.CelsiusFaren(5.0),0.1);
		assertEquals(258.15,kaks.KelvinFaren(5.0),0.1);
	}
	//ok
	@Test
	public void test3(){
		Kelvin kolm = new Kelvin();
		assertEquals(-272.15,kolm.CelsiusKelvin(1.0),0.1);
		assertEquals(-450.67,kolm.FarenKelvin(5.0),0.1);
	}
	
	
}

//KelvinCelsius?x=500