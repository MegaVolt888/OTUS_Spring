package ru.sorokinkv.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.sorokinkv.spring.dao.AnswerDao;
import ru.sorokinkv.spring.dao.AnswerDaoImpl;

@PropertySource("classpath:application.properties")
@Configuration
public class AnswerDaoConfig {
    @Bean
    public AnswerDao answerDao() {
        return new AnswerDaoImpl();
    }
}
