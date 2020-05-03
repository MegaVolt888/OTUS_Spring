package ru.sorokinkv.homework03.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionsServiceImplTest {

    @Autowired
    QuestionsService questionsService;

    @Test
    void getAllQuestion() {
        assert(!questionsService.getAllQuestion().isEmpty());
    }
}