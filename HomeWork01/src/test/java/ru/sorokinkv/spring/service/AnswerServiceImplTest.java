package ru.sorokinkv.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.UUID;


class AnswerServiceImplTest {
    final static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    final static AnswersService answersService = context.getBean(AnswersService.class);

    @Test
    void getAllAnswers() throws IOException {
        Assertions.assertNotEquals(0, answersService.getAllAnswers().size(), "Answers List is received");
    }

    @Test
    void getAnswerByUUID() throws IOException {
        Assertions.assertEquals(answersService.getAnswerByUUID(UUID.fromString("ac5065b6-53d6-40fa-bc67-94b6534c3b96")).getAnswer(), "answer1");
    }

}
