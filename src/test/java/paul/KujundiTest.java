package paul;

import org.junit.*;
import static org.junit.Assert.*;

public class KujundiTest {

	Pyramiid s1=new Pyramiid(4, 6);
	@Test
	public void p6hjapindala() {
		assertEquals(16, s1.pyramiidip6hjaPindala(), 1);
	}

	@Test
	public void ruumala() {
	  assertEquals(32, s1.pyramiidiRuumala(), 1);
	}
}