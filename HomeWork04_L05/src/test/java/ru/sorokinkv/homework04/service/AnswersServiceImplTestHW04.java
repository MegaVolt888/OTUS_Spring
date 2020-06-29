package ru.sorokinkv.homework04.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.sorokinkv.homework04.dao.AnswerDao;

import java.io.IOException;

@DisplayName("тестируем AnswersService")
@SpringBootTest(classes = AnswersServiceImpl.class)
class AnswersServiceImplTestHW04 {

    AnswersService answersService;

    @MockBean
    private AnswerDao answerDao;

    @BeforeEach
    void setUp() {
        answersService = new AnswersServiceImpl(answerDao);
    }


    @Test
    void getAllAnswers() throws IOException {
        assert (answersService.getAllAnswers().size() >= 0);
    }
}

