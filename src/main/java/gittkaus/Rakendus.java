package gittkaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Rakendus {
	
	String Tervitus(String nimi){
		if (nimi == null) {return "Pole kedagi tervitada";}
		if (nimi.equals("")){return "Sisend on tyhi";}
		else { return "Tere, " + nimi + "!";}
	}
	
	String IDNumber(String IDkood) {
        if (IDkood == null) {return "ID puudub!";} 
		if (IDkood.equals("")) {return "ID on tyhi!";} 
		if (IDkood.length() == 11) {return "ID peab olema 11 tahemarki pikk!";}
		return IDkood;
    }
	
	String IDsugu(String IDkood){
		String kood = IDkood.substring(0,1);
		if (kood.equals("3")||kood.equals("5")||kood.equals("1")){return "See on mehe ID";}
		if (kood.equals("4")||kood.equals("6")||kood.equals("2")){return "See on naise ID";}
		return IDkood;	
	}
	
	public static void main(String[] args) {
        Rakendus rakendus = new Rakendus();
    }
}