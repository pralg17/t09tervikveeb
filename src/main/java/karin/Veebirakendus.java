package karin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication

public class Veebirakendus {

    @RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
	
	//***************
	@Autowired
	HttpSession sessioon;
	@RequestMapping("/vaatjoogiga")
	public String kogusVaadis(String mahutavus, String kogus, String jook, String omahind){    
		if(sessioon.getAttribute("vaat") == null){  //esimene kord alati
			try{
				double mahutab = Double.valueOf(mahutavus);
				double joogiKogus = Double.valueOf(kogus);
				double hind = Double.valueOf(omahind);
				if(joogiKogus > mahutab){
				 return "Vaadis ei saa olla rohkem jooki, kui vaat mahutab";
				}
				Joogivaat v = new Joogivaat(mahutab);  
				v.jookiVaadis = joogiKogus;               //palju jooki vaadis
				v.j = new Jook(jook, hind);  
				sessioon.setAttribute("vaat", v);  //vaadiandmed seotakse s6naga vaat
			} catch (NumberFormatException ex){
				return "Sisesta vaadi ruumala, joogi kogus ja omahind numbritega.";
			}
			
			
		}
		Joogivaat v1 = (Joogivaat)sessioon.getAttribute("vaat");  //vaat v1 = sessiooni alguses saadetud vaadi andmed
		return "Vaat mahutab: " + v1.ruumala + " liitrit, vaadis: " + v1.j.nimetus + ", algne kogus: " +v1.jookiVaadis + " liitrit.";
	}
	
	@RequestMapping("/kast")
	public String lisakast(String hind, String mass, String mahutavus){ 
		if(sessioon.getAttribute("kast") == null){ 
			try{
				double kastiHind = Double.valueOf(hind);
				double kastiKaal = Double.valueOf(mass);
				int mahutab = Integer.valueOf(mahutavus);
				Kast k = new Kast(kastiHind, kastiKaal, mahutab); 
				sessioon.setAttribute("kast", k);
			} catch (NumberFormatException ex){
				return "Sisesta kasti andmed numbritega.";
			}
		}
		Kast k1 = (Kast)sessioon.getAttribute("kast");
		return "Lisatud kast " + k1.mahutavus + "-le pudelile";
	}
	
	@RequestMapping("/pudelitearv")
	public String pudeleid(String arv){
		Integer pudelitearv = 0;
			try{
				Integer pudeliteKogus = Integer.valueOf(arv);
				if(sessioon.getAttribute("pudeliteArv") == null){ 
					sessioon.setAttribute("pudeliteArv", pudeliteKogus);
					
				} else {
					pudeliteKogus += ((Integer)sessioon.getAttribute("pudeliteArv"));
					sessioon.setAttribute("pudeliteArv", pudeliteKogus);
				}
			} catch(NumberFormatException ex) {
				return "Sisesta pudelite kogus numbritega.";
			}
			pudelitearv = (Integer)sessioon.getAttribute("pudeliteArv");
			return Integer.toString(pudelitearv);
		}
		
	@RequestMapping("/pudel")
	public String pudel(String mahutavus, String mass, String hind){
			try{
				double mahutab = Double.valueOf(mahutavus);
				double kaal = Double.valueOf(mass);
				double taaraHind = Double.valueOf(hind);
				Joogipudel p = new Joogipudel(mahutab, kaal, taaraHind);
				sessioon.setAttribute("pudeliInfo", p);
			} catch (NumberFormatException ex){
				return "Sisesta pudeli maht, kaal ja hind numbritega.";
			}
		
		Joogipudel p1 = (Joogipudel)sessioon.getAttribute("pudeliInfo");
		return "Lisati pudel mahuga: " + String.valueOf(p1.mahutavus);
		
	}
	@RequestMapping("/pudelvaadist")
	public String pudelVaadist(){ 
		Joogivaat v1 = (Joogivaat)sessioon.getAttribute("vaat"); //vaat v1 = sessiooni alguses 
		Integer pudelitearv = (Integer)sessioon.getAttribute("pudeliteArv");
		Joogipudel p1 = (Joogipudel)sessioon.getAttribute("pudeliInfo");
		if(v1 == null){
			return "Vaat lisamata";
		}
		if( pudelitearv == null || pudelitearv == 0){
			pudelitearv = null;
			return "Pudeleid pole";
		}
		if(p1 == null){
			return "Pudelid määramata";
		}
		if(pudelitearv > 0){
			p1.joogike = null;
			
		}
		
		try{
			Joogipudel villitudpudel = v1.t2idaPudel(p1);
			if(villitudpudel == null){
				return "Kõik pudelid täidetud";
			}
			String pudeleidAlles = pudeleid("-1");
			return "Pudelis: " + villitudpudel.joogike.nimetus + ", " + villitudpudel.mahutavus + " l" + ", vaadis jooki alles: " + v1.jookiVaadis + " l" + ", pudeleid alles: " + pudeleidAlles;
			
		} catch(NumberFormatException ex){
			return "Sisesta palju pudel mahutab, pudeli kaal ja taara hind numbritega.";
		}
		
		
	}

    public static void main(String[] args) {
		//System.getProperties().put("server.port", 2412);
        SpringApplication.run(Veebirakendus.class, args);
    }
}


//scl enable rh-maven33 bash
//mvn package
//java -jar target/joogid-1.0-SNAPSHOT.jar
//http://localhost:5555/vaatjoogiga?mahutavus=500&kogus=300&jook=kali&omahind=0.6
//http://localhost:5555/pudelitearv?arv=5
//http://localhost:5555/kast?hind=4&mass=1.5&mahutavus=6
//http://localhost:5555/pudel?mahutavus=1&mass=0.1&hind=0.1
//http://localhost:5555/pudelvaadist?mahutavus=1&mass=0.1&hind=6