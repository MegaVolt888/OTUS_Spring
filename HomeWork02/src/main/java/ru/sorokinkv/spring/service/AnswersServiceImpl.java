package ru.sorokinkv.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sorokinkv.spring.dao.AnswerDao;
import ru.sorokinkv.spring.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    private AnswerDao answerDao;

    /*public AnswersServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }*/

    public ArrayList<Answer> getAllAnswers() throws IOException {
        return answerDao.getAllAnswers();
    }

    @Override
    public Answer getAnswerByUUID(UUID uuid) throws IOException {
        return answerDao.getAnswerByUUID(uuid);
    }
}
