package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class T10Application {
	@RequestMapping("/calc")

	public String arvuta( Double sum,Double period, Double intress, String bank){

		if(bank.equals("swedbank")) {

			Swedbank swed = new Swedbank(sum, period, intress);

			return String.format("%.2f", swed.Leasing());
		}

		Sebbank seb = new Sebbank(sum,period,intress);
		if(bank.equals("sebbank") && seb.Leasing() == 0)
		{
			return "Liiga suur summa, Sebbank ei anna rohkem kui 100000 EUR";
		}
		return String.format("%.2f", seb.Leasing());
	}
	public static void main(String[] args) {
		SpringApplication.run(T10Application.class, args);
	}
}
