package ru.sorokinkv.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.UUID;


class QuestionServiceImplTest {
    final static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    final static QuestionsService questionsService = context.getBean(QuestionsService.class);

    @Test
    void getAllQuestions() {
        Assertions.assertNotEquals(0,questionsService.getAllQuestion().size(),"Answers List is received");
    }



}
