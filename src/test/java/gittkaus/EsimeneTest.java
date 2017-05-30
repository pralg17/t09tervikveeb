package gittkaus;

import org.junit.*;

import static org.junit.Assert.*;

public class EsimeneTest {

    Rakendus rakendus = new Rakendus();

	@Test
	public void test(){
		assertEquals("Pole kedagi tervitada", rakendus.Tervitus(null));
		assertEquals("Sisend on tyhi", rakendus.Tervitus(""));
		assertEquals("Tere, Gittan!", rakendus.Tervitus("Gittan"));
	}
	
    @Test
    public void IDtest1() {
        assertEquals("ID puudub!", rakendus.IDNumber(null));
		assertEquals("ID on tyhi!", rakendus.IDNumber(""));
        assertEquals("ID peab olema 11 tahemarki pikk!", rakendus.IDNumber("38905220293"));
    }
	
	@Test 
	public void IDtest2(){
		assertEquals("See on mehe ID", rakendus.IDsugu("38905220293"));
		assertEquals("See on naise ID", rakendus.IDsugu("49409262769"));
	}
}