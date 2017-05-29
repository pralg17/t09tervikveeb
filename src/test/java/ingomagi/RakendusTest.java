package ingomagi;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RakendusTest{
	
    @Test
	public void katse0(){
		assertEquals(3, 2+1);
	}
	
	@Test
	public void katse1(){
		Rakendus r=new Rakendus();
		assertEquals("Arvu ruut on: "+String.valueOf(16.0), r.ruut("4"));
	}
	 
	@Test
	public void katse2(){
		Rakendus r=new Rakendus();
		assertEquals("ringi pindala on: "+String.valueOf(314), r.proov(10.0));
	}    
	@Test
	public void katse3(){
		Rakendus r=new Rakendus();
		assertEquals("Ruudu ümbermõõt on: "+String.valueOf(20), r.proov3(5.0));
	}    
	 
}