package alar;

import org.springframework.boot.SpringApplication;

/**
 * Created by Alar Aasa on 07.05.2017.
 */
public class Main {

    public static void main(String[] args){
        System.getProperties().put("server.port", 4889);
        SpringApplication.run(Application.class, args);
    }
}
