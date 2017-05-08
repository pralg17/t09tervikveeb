package melissa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication
public class Rakendus1 {
	@Autowired
	HttpSession sessioon;
	//Joogivaat vaat=new Joogivaat();
	@RequestMapping("/kogusvaadis")
	public String kogusVaadis(){ //tekitab vaadi kui vaja
		if(sessioon.getValue("vaat")==null){
			Joogivaat v=new Joogivaat();
			v.vaadimaht=500;
			v.taidetudmaht=300;
			v.j=new Jook("Kali", 0.3, 1.01);
			sessioon.putValue("vaat", v);
		}
		Joogivaat v1=(Joogivaat)sessioon.getValue("vaat");
		return "Vaadis "+v1.j.nimetus+
		       ", alles "+v1.taidetudmaht+" liitrit.";
	}
	
	@RequestMapping("/pudelvaadist")
	public String pudelVaadist(){ //eeldab vaadi olemasolu
		Joogivaat v1=(Joogivaat)sessioon.getValue("vaat");
		if(v1==null){return "vaat puudub";}
		Joogipudel suurpudel=new Joogipudel();
		suurpudel.tyyp=pudelityyp.PLASTIK;
		suurpudel.pudelimass=0.08;
		suurpudel.taarahind=0.1;
		suurpudel.maht=1.5;
		Joogipudel villitudpudel=v1.villi(suurpudel);
		if(villitudpudel==null){return "villimisprobleem";}
		return "Villiti "+suurpudel.j.nimetus+", "+suurpudel.maht+" liitrit. "+
		  kogusVaadis();
	}
	
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4217);
		SpringApplication.run(Rakendus1.class);
	}
}


//[melissab@greeny Joogid]$ java -jar  //target/pudelid-0.0.1-SNAPSHOT.jar
//Õlu mass: 0.75 ja hind: 0.55
//Siirup mass: 0.45 ja hind: 0.2875
