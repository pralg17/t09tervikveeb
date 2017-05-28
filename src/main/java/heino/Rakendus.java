package heino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Rakendus{



	private final MenyyHaldur haldur;



	    @Autowired
	    public Rakendus(MenyyHaldur haldur) {
	        this.haldur = haldur;
	    }

  @RequestMapping("/listall")
		    String listall(String toidu_nimetus) {
		        StringBuffer sb = new StringBuffer();
						//Võtab andmebaasist toiduained
		        for (Toidud item : haldur.findAll()) {
		            sb.append(item);
		        }
		        String thead = "<tr><th>Id</th><th>Nimetus</th><th>Tüüp</th><th>Hind</th></tr>";
		        return thead + sb.toString();
		    }
	@RequestMapping("/lisa")
				///lisa?toidu_nimetus=Kartulid&toidu_tyyp=Praad&hind=3
				public String lisa(String toidu_nimetus, String toidu_tyyp, double hind) {
							Toidud toit = new Toidud();
							toit.toidu_nimetus = toidu_nimetus;
							toit.toidu_tyyp = toidu_tyyp;
							toit.hind = hind;
							haldur.save(toit);
					return "Lisatud " + toidu_nimetus + " " + toidu_tyyp + " hinnaga " + hind+" euri ";
				}

	@RequestMapping("/kustuta")
   String kustuta(Integer id) {
         Toidud toit = haldur.findOne(id);
 					if(toit==null){return "Antud id-ga toitu ei leidu";}
 				//Kustutab tabelist toiduained vastava id-ga kirje
        haldur.delete(toit);


       return toit.toidu_nimetus + " " + " on kustutatud";

     }

 @RequestMapping("/hinnavahemik")
	 		public String rasvaotsing(double hind_min, double hind_max){
	 			StringBuffer sb = new StringBuffer();
	 			for(Toidud item : haldur.findAll()){
	 				if(item.hind > hind_min && item.hind < hind_max){
	 					sb.append(item);
	 					//return "Otsimine õnnestus";
	 				}
	 			}
	 			//Tabeli lahtrite nimetused
	 			String thead = "<tr><th>Id</th><th>Nimetus</th><th>Tüüp</th><th>Hind</th></tr>";
	 			//Tagastab tabeli lahtrite nimetused ja sb-s oleva info
	          return thead + sb.toString();
	 		}
	public static void main(String[] args) {
		System.getProperties().put("server.port", 12236);
		/* System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_heinop2rn?useSSl=false");
		System.getProperties().put("spring.datasource.username", "if16");
 		System.getProperties().put("spring.datasource.password", "ifikad16"); */
        SpringApplication.run(Rakendus.class);

    }
}


//scl enable rh-maven33 bash
//mvn package
//java -jar target/menyy-1.jar
