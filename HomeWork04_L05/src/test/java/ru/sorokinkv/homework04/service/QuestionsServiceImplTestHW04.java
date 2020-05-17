package ru.sorokinkv.homework04.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.sorokinkv.homework04.dao.QuestionDao;

@DisplayName("тестируем QuestionsService")
@SpringBootTest(classes = QuestionsServiceImpl.class)
class QuestionsServiceImplTestHW04 {

    QuestionsService questionsService;

    @MockBean
    private QuestionDao questionDao;

    @BeforeEach
    void setUp() {
        questionsService = new QuestionsServiceImpl(questionDao);
    }


    @Test
    void getAllQuestion() {
        assert (questionsService.getAllQuestion().size() >= 0);
    }
}
