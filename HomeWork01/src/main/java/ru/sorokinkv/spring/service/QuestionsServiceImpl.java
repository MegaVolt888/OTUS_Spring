package ru.sorokinkv.spring.service;

import ru.sorokinkv.spring.dao.QuestionDao;
import ru.sorokinkv.spring.dao.QuestionDaoImpl;
import ru.sorokinkv.spring.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionsServiceImpl implements QuestionsService {
    private QuestionDao questionDao;

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
