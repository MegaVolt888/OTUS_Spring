package ru.sorokinkv.spring.service;

import ru.sorokinkv.spring.dao.AnswerDao;
import ru.sorokinkv.spring.dao.AnswerDaoImpl;
import ru.sorokinkv.spring.model.Answer;

import java.util.ArrayList;

public class AnswersServiceImpl implements AnswersService {
    private AnswerDao answerDao;
    public ArrayList<Answer> getAllAnswers() {
        return answerDao.getAllAnswers();
    }
/*     public void setAnswerDao(AnswerDao answerDao){
        this.answerDao = answerDao;
     }*/

    public void setDao(AnswerDaoImpl dao) {
        this.answerDao = dao;
    }
}
