package margid;
public class Mass{
	public static void main(String argumendid[]){
		Jook jook1=new Jook();
		jook1.nimetus="vesi";
		jook1.erikaal= 1;
		jook1.Lomahind= 3;
		Joogipudel joogipudel1=new Joogipudel();
		joogipudel1.pudelityyp="klaas";
		joogipudel1.mass= 100;
		joogipudel1.maht= 500;
		joogipudel1.maksumus= 10;
		joogipudel1.sisu=jook1;
		if (joogipudel1.maht!= 0){
			int kogumass=jook1.erikaal*joogipudel1.maht+joogipudel1.mass;
			System.out.println("kogumass on "+kogumass);
			int omahind=jook1.Lomahind+joogipudel1.maksumus;
			System.out.println("omahind on "+omahind);
		}

	}
}

// scl enable rh-maven33 bash
// mvn package
// java -jar target/jook-1.jar
//
// kogumass on 600
// omahind on 13
