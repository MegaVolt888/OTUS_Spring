package ru.sorokinkv.homework03.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.homework03.dao.QuestionDao;
import ru.sorokinkv.homework03.model.Question;

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
