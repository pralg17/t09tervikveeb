package margid;

import org.junit.*;
import static org.junit.Assert.*;

public class Test1{
	@Test
	public void test1(){
		Jook jook1=new Jook();
		jook1.nimetus="vesi";
		jook1.erikaal=1;
		jook1.Lomahind=3;
		Joogipudel joogipudel1=new Joogipudel();
		joogipudel1.pudelityyp="klaas";
		joogipudel1.mass=100;
		joogipudel1.maht=500;
		joogipudel1.maksumus=10;
		joogipudel1.sisu=jook1; 
		int kogumass=jook1.erikaal*joogipudel1.maht+joogipudel1.mass;
		System.out.println(kogumass);
		int omahind=jook1.Lomahind+joogipudel1.maksumus;
		System.out.println(omahind);
	}
}