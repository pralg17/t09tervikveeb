package uku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import java.lang.*;

@RestController
@SpringBootApplication

public class Veebileht{
	
	
	@RequestMapping("/Puudu")
	public String Puudu (){
		return "Vastus puudu";
		
	}

	@RequestMapping("/xKordaja")
	public double xKordaja (double x){
		double vastus;
		xKordaja x1=new xKordaja(7);//xkordaja annan sisse

		vastus = x1.kordaja*x;
		return vastus;
		
	}
	
	@RequestMapping("/Vabaliige")
	public double Vabaliige (double x, double vabaliige){
		double vastus;
		Vabaliige vabaliikmega=new Vabaliige(7.0,2.0);//xkordaja annan sisse
		vastus = vabaliikmega.kordaja*x+vabaliige;
		return vastus;
		
	}
	@RequestMapping("/Parabool")
	public double Parabool (double kordaja, double aste){
		double vastus;
		Parabool parabooliga=new Parabool(kordaja, aste);//xkordaja annan sisse
		vastus = Math.pow(parabooliga.kordaja, parabooliga.aste);
		return vastus;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.getProperties().put("server.port", 42278);
        SpringApplication.run(Veebileht.class, args);
    }
	
}