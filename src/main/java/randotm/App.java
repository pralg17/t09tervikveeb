package randotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class App {
    @Autowired
    
    private DbDao dbDao;
	
    @RequestMapping("/save")
	String lisa(Float temp, String moment){
        if(temp == null) {
            return "Temperatuur sisestamata";
        }
        Db mom = new Db();
        mom.temper = temp;
        mom.moment = moment;
        dbDao.save(mom);
        return "Lisatud " + temp + " kraadi Celsiust @ " + moment;
	}

	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4200);
        SpringApplication.run(App.class, args);
    }
}