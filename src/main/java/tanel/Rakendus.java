package tanel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Rakendus{

    @RequestMapping("/tervita")
    public String tervitamine(String eesnimi){
        return "Tere "+eesnimi;
    }

    @RequestMapping("/mitteAktiivne")
    public String mitteAktiivne(int kaal, int pikkus, int vanus){
        mitteAktiivne ma1 =new mitteAktiivne(kaal, pikkus, vanus);
        return "Mitte aktiivse kalorivajadus: "+ma1.kaloriVajadus();
    }

    @RequestMapping("/keskmineAktiivne")
    public String keskmineAktiivne(int kaal, int pikkus, int vanus){
        keskmineAktiivne ka1 =new keskmineAktiivne(kaal, pikkus, vanus);
        return "Keskmiselt aktiivse kalorivajadus: "+ka1.kaloriVajadus();
    }

    @RequestMapping("/vagaAktiivne")
    public String vagaAktiivne(int kaal, int pikkus, int vanus){
        vagaAktiivne va1 =new vagaAktiivne(kaal, pikkus, vanus);
        return "Väga aktiivse kalorivajadus: "+va1.kaloriVajadus();
    }

    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }
}

/*
/mitteAktiivne?kaal=50&pikkus=150&vanus=21
Mitte aktiivse kalorivajadus: 1804.44

/keskmineAktiivne?kaal=50&pikkus=150&vanus=21
Keskmiselt aktiivse kalorivajadus: 2330.735

/vagaAktiivne?kaal=50&pikkus=150&vanus=21
Väga aktiivse kalorivajadus: 2857.0299999999997

*/