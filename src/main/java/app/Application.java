package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class Application{

	Painting p1 = new Painting("Picasso","The Weeping Woman", "Cubism");
    Painting p2 = new Painting("van Gogh", "The Starry Night", "Post-Impressionism");
    Painting p3 = new Painting("Kahlo","The Two Fridas","Naive art");
    Painting p4 = new Painting("Notke","Dance of Death","Allegory");
	
    public List<Painting> paintings = new ArrayList<Painting>(){{
        add(p1);
        add(p2);
        add(p3);
        add(p4);
    }};
	
	@RequestMapping("/index")
	public String index(){
		
		StringBuffer sb = new StringBuffer();
		for(Painting p : paintings){
			sb.append("<p>");
			sb.append(p.lastName + ", " + p.painting + ", " + p.genre);
			sb.append("</p>");
		}
		
		return sb.toString();
		
	}
	
	@RequestMapping("/edit")
	public String edit(String artist, String painting, String genre){
		
		for(Painting p: paintings){
			if(p.lastName.equals(artist)){
				p.painting = painting;
				p.genre = genre;
				
				return "Edited!";
			}
		}
		return "Artist not found!";
		
	}
	

    public static void main(String[] args){
        System.getProperties().put("server.port", 8080);
        SpringApplication.run(Application.class, args);
    }
}