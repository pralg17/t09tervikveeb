package Rait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus {
	@Autowired
    private FilmidDao filmid;
	
	@RequestMapping("/vaadatud")
	String vaadatud(){
		StringBuffer sb=new StringBuffer();
		for(Filmid film: filmid.findAll()){
			if(film.seis.equals("vaadatud")){
				sb.append(film.nimi + "(" + film.aasta + ")" + "<br>");
			}
		}
		return "<p>Vaadatud filmid: " + "<br>" + sb.toString() + "</p>";
	}
	
	@RequestMapping("/vaatamata")
	String vaatamata(){
		StringBuffer sb=new StringBuffer();
		for(Filmid film: filmid.findAll()){
			if(film.seis.equals("vaatamata")){
				sb.append(film.nimi + "(" + film.aasta + ")" + "<br>");
			}
		}
		return "Vaatamata filmid: " + "<br>" + sb.toString();
	}
	
	@RequestMapping("/pooleli")
	String pooleli(){
		StringBuffer sb=new StringBuffer();
		for(Filmid film: filmid.findAll()){
			if(film.seis.equals("pooleli")){
				sb.append(film.nimi + "(" + film.aasta + ")" + "<br>");
			}
		}
		return "Pooleliolevad filmid: " + "<br>" + sb.toString();
	}
	
	@RequestMapping("/lisa")
	String lisa(String nimi, int aasta, String seis, int pikkus){
		Filmid film=new Filmid();
	   
		if(nimi==null || aasta==0 || seis==null || pikkus==0){return "Andmed puudulikud!";}
		else{
			film.nimi=nimi;
			film.aasta=aasta;
			film.seis=seis;
			film.pikkus=pikkus;
			filmid.save(film);
			return "Lisatud: "+nimi+"("+aasta+"), "+pikkus+" min - "+seis;
		}
	}
	
	@RequestMapping("/muuda")
	String muuda(String nimi, String seis){
		
		if(nimi==null || "".equals(nimi)){return "Filmi nimi sisestamata!";}
		if("vaatamata".equals(seis) || "vaadatud".equals(seis) || "pooleli".equals(seis) ){
			Filmid film=filmid.findOne(nimi);
			
			if(film==null){return "Sellist filmi ei ole andmebaasis!";}
			else{
				film.seis=seis;
				filmid.save(film);
				return "Muudetud: "+film.nimi+"("+film.aasta+") "+film.pikkus+" min - "+film.seis;
			}
		}else{return "Ebasobiv või puuduv seis!";}
	}
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4218);
        SpringApplication.run(Rakendus.class, args);
    }
}





