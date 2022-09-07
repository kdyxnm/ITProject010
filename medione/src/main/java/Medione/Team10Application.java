package Medione;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Team10Application {

    public static void main(String[] args) {
        SpringApplication.run(Team10Application.class, args);
        System.out.println("see this line means running is successful");
    }

}
