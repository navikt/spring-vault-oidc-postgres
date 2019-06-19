package no.nav.academy.exapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AcademyExApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AcademyExApplication.class)
                .main(AcademyExApplication.class)
                .run(args);
    }
}