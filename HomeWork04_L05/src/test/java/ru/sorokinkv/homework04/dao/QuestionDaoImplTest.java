package ru.sorokinkv.homework04.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@DisplayName("тестируем QuestionDao")
@SpringBootTest
class QuestionDaoImplTest {
    @Autowired
    protected QuestionDao questionDao;

    @Test
    void getAllQuestion() throws IOException {
        assert (!questionDao.getAllQuestions().isEmpty() && questionDao.getAllQuestions()!=null);
    }

}