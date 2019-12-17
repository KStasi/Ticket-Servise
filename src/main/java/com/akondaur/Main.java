package com.akondaur;

// import com.akondaur.model.Client;
import com.akondaur.spring.config.SpringConfig;
// import com.akondaur.spring.dao.ClientDao;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
