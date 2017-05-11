package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import java.lang.Math;

@RestController
@SpringBootApplication
public class Rakendus {
	@Autowired
	HttpSession sessioon;
	@RequestMapping("/kogusvaadis")
	public String kogusVaadis(){
		if(sessioon.getValue("vaat")==null){
			Joogivaat v=new Joogivaat();
			v.vaadimaht=500;
			v.taidetudmaht=300;
			v.j=new Jook("Kali", 0.3, 1.01);
			sessioon.putValue("vaat", v);
		}
		Joogivaat v1=(Joogivaat)sessioon.getValue("vaat");
		return "Vaadis "+v1.j.nimetus+", alles "+v1.taidetudmaht+"liitrit.";
	}
	
	@RequestMapping("/pudelvaadist")
	public String pudelVaadist(){
		Joogivaat v1=(Joogivaat)sessioon.getValue("vaat");
		if(v1==null){return "vaat puudub";}
		Joogipudel suurpudel=new Joogipudel();
		suurpudel.tyyp=Pudelityyp.PLASTIK;
		suurpudel.pudelimass=0.08;
		suurpudel.taaramaksumus=0.1;
		suurpudel.maht=1.5;
		suurpudel.korgiKorgus=1.5;
		suurpudel.korgiDiameeter=3;
		Joogipudel villitudpudel=v1.villi(suurpudel);
		if(villitudpudel==null){return "villimisprobleem";}
		return "Villiti "+suurpudel.j.nimetus+", "+suurpudel.maht+" liitrit. "+kogusVaadis() + " Villitava pudeli korgi ruumala on " + Math.round((Math.PI*Math.pow((suurpudel.korgiDiameeter/2), 2)*suurpudel.korgiKorgus)) + "sentimeetrit";
	}
	
	@RequestMapping("/pudelvaati")
	public String pudelVaati(){
		Joogivaat v1=(Joogivaat)sessioon.getValue("vaat");
		if(v1==null){return "vaat puudub";}
		Joogipudel suurpudel=new Joogipudel();
		suurpudel.maht=1.5;
		Joogipudel villitudpudel=v1.ime(suurpudel);
		if(villitudpudel==null){return "imemisprobleem";}
		return "Imeti " + suurpudel.maht + "liitrit jooki nimega "+suurpudel.j.nimetus+". " kogusVaadis();
	}
	
	
	public static void main(String[] args){
		System.getProperties().put("server.port", 6537);
		SpringApplication.run(Rakendus.class);
	}
	
//java -Djava.security.edg=file:/dev/./urandom -jar demo-jar

}
	