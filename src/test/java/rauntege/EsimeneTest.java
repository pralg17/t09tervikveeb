package rauntege;

import org.junit.*;
import static org.junit.Assert.*;

public class EsimeneTest{
	
	@Test
	public void test(){
		Jook jo1 = new Jook("Vesi", 500, 0.5);
		Joogipudel pu1 = new Joogipudel("Purk", 500, 10, 0.10, jo1);
		assertEquals(510, jo1.erikaal+pu1.mass);
	}
}