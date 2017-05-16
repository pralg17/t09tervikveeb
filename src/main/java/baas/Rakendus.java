package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus{

    private final ProtsentData pData;
    private final LiigiData lData;

    @Autowired
    public Rakendus(ProtsentData pData, LiigiData lData){
        this.pData = pData;
        this.lData = lData;
    }


  @RequestMapping("/koikIsendid")
  public String koikIsendid(){
      StringBuilder stringBuffer = new StringBuilder();
       for(Isendid isend: lData.findAll()){
               stringBuffer.append("<p>").append(isend.toString()).append(" Kehamassiindeks: ").append(isend.Kehamassiindeks());
       }
       return stringBuffer.toString();
  }

  @RequestMapping("/kahanev")
  public String kahanev(){
      StringBuilder stringBuffer = new StringBuilder();
       for(Isendid isend: lData.findAllByOrderByKaalAsc()){
               stringBuffer.append("<p>").append(isend.toString()).append(" Kehamassiindeks: ").append(isend.Kehamassiindeks());
       }
       return stringBuffer.toString();
  }
  public static void main(String[] args) {
    System.getProperties().put("server.port", "1720");
    System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_karroo?useSSL=false");
    System.getProperties().put("spring.datasource.maxActive", "2");
    System.getProperties().put("spring.datasource.username", "if16");
    System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}
}
