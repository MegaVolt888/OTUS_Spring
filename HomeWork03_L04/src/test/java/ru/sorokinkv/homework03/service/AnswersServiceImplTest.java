package ru.sorokinkv.homework03.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class AnswersServiceImplTest {
    @Autowired
    AnswersService answersService;

    @Test
    void getAllAnswers() throws IOException {
        assert(!answersService.getAllAnswers().isEmpty());
    }
}