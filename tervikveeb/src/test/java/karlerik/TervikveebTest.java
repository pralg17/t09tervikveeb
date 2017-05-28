package karlerik;

import org.junit.*;
import static org.junit.Assert.*;

public class TervikveebTest {
	
	@Test
	public void shoppingcartTest1() {
		Elektrikitarr e = new Elektrikitarr("3");
		assertEquals(1350, e.calculatePrice(), 0.01);
	}
	
	public void shoppingcartTest2() {
		Elektrikitarr e = new Elektrikitarr("2");
		assertEquals(1000, e.calculatePrice(), 0.01);
	}
	
	public void shoppingcartTest3() {
		Kitarrikeeled k = new Kitarrikeeled("5");
		assertEquals(40, k.calculatePrice(), 0.01);
	}
	
	public void shoppingcartTest4() {
		Kitarrikeeled k = new Kitarrikeeled("6");
		assertEquals(43.2, k.calculatePrice(), 0.01);
	}
	
	public void shoppingcartTest5() {
		Medikas m = new Medikas("5");
		assertEquals(25, m.calculatePrice(), 0.01);
	}
	
	public void shoppingcartTest6() {
		Medikas m = new Medikas("6");
		assertEquals(27, m.calculatePrice(), 0.01);
	}
	
	
	
}