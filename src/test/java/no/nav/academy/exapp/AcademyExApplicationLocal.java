package no.nav.academy.exapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import java.io.IOException;

import static no.nav.academy.exapp.util.EnvUtil.DEV;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@SpringBootApplication
@EnableCaching
@ComponentScan(excludeFilters = { @Filter(type = ASSIGNABLE_TYPE, value = AcademyExApplication.class) })
public class AcademyExApplicationLocal {

    public static void main(String[] args) throws IOException {
        new SpringApplicationBuilder(AcademyExApplicationLocal.class)
                .profiles(DEV)
                .main(AcademyExApplicationLocal.class)
                .run(args);
    }

}
