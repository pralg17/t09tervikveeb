package sten;

import org.junit.*;
import static org.junit.Assert.*;

public class SilindriTest {

	Silinder s1=new Silinder(4, 6);
	@Test
	public void RingiPindala() {
		assertEquals(16, s1.Ringipindala(), 1);
	}

	@Test
	public void ruumala() {
	  assertEquals(301.44, s1.silindriRuumala(), 1);
	}
}
