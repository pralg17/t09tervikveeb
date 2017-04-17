package Kristjan;

import org.junit.*;
import static org.junit.Assert.*;

public class pyramiidiTest{
		@Test
		public void ruumala(){
			pyramiid r2=new pyramiid(5.0,5.0,5.0);
			assertEquals(62.5,r2.ruumala(), 0.01);
		}
		@Test
		public void kuljePindala(){
			pyramiid r3=new pyramiid(5.0,5.0,5.0);
			assertEquals(50.0,r3.kuljePindala(), 0.01);
		}
}