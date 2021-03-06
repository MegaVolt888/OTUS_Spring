package ru.sorokinkv.spring.service;

import ru.sorokinkv.spring.dao.AnswerDao;
import ru.sorokinkv.spring.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class AnswersServiceImpl implements AnswersService {
    private AnswerDao answerDao;

    public AnswersServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public ArrayList<Answer> getAllAnswers() throws IOException {
        return answerDao.getAllAnswers();
    }

    @Override
    public Answer getAnswerByUUID(UUID uuid) throws IOException {
        return answerDao.getAnswerByUUID(uuid);
    }
}
