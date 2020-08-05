package fr.mistral.backendprojects.javatechie;

import fr.mistral.backendprojects.javatechie.dao.UserRepository;
import fr.mistral.backendprojects.javatechie.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaTechieApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTechieApplication.class, args);
    }

    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*");

    }


}
