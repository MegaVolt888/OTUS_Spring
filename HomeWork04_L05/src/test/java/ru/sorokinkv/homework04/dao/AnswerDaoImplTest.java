package ru.sorokinkv.homework04.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("тестируем AnswerDao")
@SpringBootTest
class AnswerDaoImplTest {
    @Autowired
    protected AnswerDao answerDao;

    @Test
    void getAllAnswer() throws IOException {
        assert (!answerDao.getAllAnswers().isEmpty() && answerDao.getAllAnswers()!=null);
    }

}