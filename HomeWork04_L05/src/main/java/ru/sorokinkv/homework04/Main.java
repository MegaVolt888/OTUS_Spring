package ru.sorokinkv.homework04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.sorokinkv.homework04.config.AppConfig;
import ru.sorokinkv.homework04.service.TestStudent;


@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class Main {
    public static void main(String[] args) {SpringApplication.run(Main.class, args);  }
}
