package cleven;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class iooniLoomineTest {

	@Test
	public void ioonTest(){
		ioon i1=new ioon("H", 1, 1);
		ioon i2=new ioon("(NO3)", 62, (-1));
		assertEquals("H", i1.nimetus);
		assertEquals(1, i1.aatommasside_summa, 0.01);
		assertEquals(1, i1.laeng, 0.01);
		assertEquals("(NO3)", i2.nimetus);
		assertEquals(62, i2.aatommasside_summa, 0.01);
		assertEquals((-1), i2.laeng, 0.01);
	}
	
	@Test
	public void aineTest(){
		ioon i1=new ioon("H", 1, 1);
		ioon i2=new ioon("(NO3)", 62, (-1));
		aine a1=new aine(i1,i2);
		ioon i3=new ioon("Ca", 40, 2);
		ioon i4=new ioon("Cl", 35.5, (-1));
		aine a2=new aine(i3,i4);
		assertEquals("H(NO3)", a1.nimetus);
		assertEquals(63, a1.molekulmass, 0.01);
		assertEquals("null", a2.nimetus);
		assertEquals(75.5, a2.molekulmass, 0.01);		
	}
	
	@Test
	public void aine_massiivTest(){
		ioon i1=new ioon("H", 1, 1);
		ioon i2=new ioon("(NO3)", 62, (-1));
		ioon i3=new ioon("Ca", 40, 2);
		ioon i4=new ioon("Cl", 35.5, (-1));
		ioon i5=new ioon("H", 1, 1);
		ioon[] massiiv = new ioon[]{i1,i2,i3,i4,i5};
		aine_massiiv ioonid = new aine_massiiv(massiiv);
		assertEquals("H2(NO3)CaCl", ioonid.nimetus);		
	}
}