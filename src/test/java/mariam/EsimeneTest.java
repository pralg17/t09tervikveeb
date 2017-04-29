package mariam;

import org.junit.*;
import static org.junit.Assert.*;

public class EsimeneTest{
	@Test
	public void test1(){
		Euroks yks = new Euroks();
		assertEquals(14.6849617,yks.dollarEuroks(16.0),0.1);
		assertEquals( 0.644669818,yks.rublaEuroks(40.0),0.1);
	}
	
	@Test
	public void test2(){
		Rublaks kolm = new Rublaks();
		assertEquals(310.236333,kolm.eurodRublaks(5.0),0.1);
		assertEquals(341.685649,kolm.dollaridRublaks(6.0),0.1);
	}
	
	@Test
	public void test3(){
		Dollariks kaks = new Dollariks();
		assertEquals(16.34325,kaks.eurodDollariks(15.0),0.1);
		assertEquals(4.39,kaks.rublaDollariks(250.0),0.1);
	}
	
	
}