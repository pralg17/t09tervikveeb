package matu;

import org.junit.*;
import static org.junit.Assert.*;

public class KeraTest {
	
	Kera s1=new Kera(5, 0.3333333333333333);
	@Test
	public void pindala() {
		assertEquals(314, s1.ringiPindala(), 1);
	}

	@Test
	public void ruumala() {
	  assertEquals(523, s1.keraruumala()*5, 1);
	}
}