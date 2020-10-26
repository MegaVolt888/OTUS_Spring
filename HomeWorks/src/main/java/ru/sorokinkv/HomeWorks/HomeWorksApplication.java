package ru.sorokinkv.HomeWorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.sorokinkv.HomeWorks.config.ApplicationConfig;


@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class HomeWorksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorksApplication.class, args);
    }

}
