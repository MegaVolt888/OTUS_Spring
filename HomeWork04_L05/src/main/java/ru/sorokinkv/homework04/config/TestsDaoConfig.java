package ru.sorokinkv.homework04.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sorokinkv.homework04.dao.AnswerDao;
import ru.sorokinkv.homework04.dao.AnswerDaoImpl;
import ru.sorokinkv.homework04.dao.QuestionDao;
import ru.sorokinkv.homework04.dao.QuestionDaoImpl;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "data")
@Data
public class TestsDaoConfig {
    private String answers;
    private String questions;

    @Bean
    public AnswerDao answerDao() {
        return new AnswerDaoImpl(answers);
    }

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl(questions);
    }
}

