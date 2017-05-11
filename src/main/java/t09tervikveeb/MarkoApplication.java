package t09tervikveeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarkoApplication {

	Ruut test_ruut = new Ruut(7);
	Kolmnurk test_kolmnurk = new Kolmnurk(5,6);
	Puramiid test_puramiid = new Puramiid(test_ruut, test_kolmnurk);



	@RequestMapping("/createpyramid")
	public String giveData(double ruut_kulg, double kolmnurk_alus, double kolmnurk_kaatet){
		Ruut ruut = new Ruut(ruut_kulg);
		Kolmnurk kolmnurk = new Kolmnurk(kolmnurk_alus, kolmnurk_kaatet);
		Puramiid puramiid = new Puramiid(ruut,kolmnurk);
		double v1 = puramiid.getPuramiid_pindala();
		double v2 = puramiid.getPuramiid_ruumala();

		return "Püramiidi pindala on: " + v1 + " ja ruumala on " + v2;
	}


	public static void main(String[] args) {
		SpringApplication.run(MarkoApplication.class, args);







	}
}
