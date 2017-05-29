package cleven;

import java.util.*;
import java.lang.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication

public class rakendus {
	
	@Autowired
	HttpSession session;
	private ArticleTable table;
	
	@RequestMapping("/tervita")
    public String tervitusfunktsioon() {
        return "tervitus";
    }
	
	@RequestMapping("/save_article")
	public String save(String title, String category){
		table.save(new ArticleEntity(title, category));
		return "artikkel salvestatud";
	}
	
	@RequestMapping("/lisaioon")
	public String lisaIoon(String nimetus, double aatommass, int laeng){
		ioon i1= new ioon(nimetus, aatommass, laeng);
		if(session.getValue("ioonid")==null){
			ioon[] massiiv = new ioon[]{i1};
			session.putValue("ioonid", massiiv);
		}else{
			ioon[] vana_massiiv=(ioon[])session.getValue("ioonid");
			ioon[] massiiv = new ioon[vana_massiiv.length+1];
			for (int i=0;i<massiiv.length;i++){
				if(i==massiiv.length-1){
					massiiv[i]=i1;
				}else{
					massiiv[i]=vana_massiiv[i];
				}
			}
			session.putValue("ioonid", massiiv);
		}
		return "Lisati ioon "+i1.nimetus;
	}
	
	@RequestMapping("/tekitaaine")
	public String tekitaAine(){
		ioon[] massiiv=(ioon[])session.getValue("ioonid");
		aine_massiiv ioonid = new aine_massiiv(massiiv);
		if(ioonid.loodav){
			return "Tekitatud aine nimetus: "+ioonid.nimetus+", mille molekulmass on "+ioonid.molekulmass;
		}else{
			return "Sellist ainet ei saa luua!";
		}
		
	}
	
 
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4288);
        SpringApplication.run(rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar