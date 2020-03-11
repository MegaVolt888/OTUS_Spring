package ru.sorokinkv.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.sorokinkv.spring.dao.QuestionDao;
import ru.sorokinkv.spring.dao.QuestionDaoImpl;

@PropertySource("classpath:application.properties")
@Configuration
public class QuestinDaoConfig {
    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl();
    }
}
