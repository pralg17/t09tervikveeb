package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class Application{

    private Painting p1 = new Painting("Picasso","The Weeping Woman", "Cubism");
    private Painting p2 = new Painting("van Gogh", "The Starry Night", "Post-Impressionism");
    private Painting p3 = new Painting("Kahlo","The Two Fridas","Naive art");
    private Painting p4 = new Painting("Notke","Dance of Death","Allegory");

    public List<Painting> paintings = new ArrayList<Painting>(){{
        add(p1);
        add(p2);
        add(p3);
        add(p4);
    }};
    @RequestMapping("/")
    String index(){
        StringBuffer sb = new StringBuffer();
        for(Painting p: paintings){
            sb.append("<p>");
            String s = p.lastName + ", " + p.painting + ", " + p.genre;
            sb.append(s);
            sb.append("</p>");
        }
        return sb.toString();
    }


    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("paintings", paintings);
        return mav;
    }
    @RequestMapping("/change")
    void changePainting(String artist, String painting, String genre){

        for(Painting p: paintings){

            if(p.lastName.equals(artist)){
                p.painting = painting;
                p.genre = genre;
            }
        }
    }

    public static void main(String[] args){
        System.getProperties().put("server.port", 8080);
        SpringApplication.run(Application.class, args);
    }
}