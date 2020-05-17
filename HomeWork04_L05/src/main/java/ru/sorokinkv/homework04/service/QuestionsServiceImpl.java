package ru.sorokinkv.homework04.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.homework04.dao.QuestionDao;
import ru.sorokinkv.homework04.model.Question;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionDao questionDao;

    public QuestionsServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ArrayList<Question> getAllQuestion() {
        try {
            return questionDao.getAllQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
