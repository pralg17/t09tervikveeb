package baas;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class KTest{

	Protsent a1 = new Protsent("Hobune", 65);
	Isendid a2 = new Isendid(a1, 100, 1);


	@Test
	public void KMITestOige1() {
		Assert.assertEquals(a2.Kehamassiindeks(), 100, 1);
	}


}
