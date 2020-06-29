package ru.sorokinkv.homework04.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.homework04.dao.AnswerDao;
import ru.sorokinkv.homework04.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class AnswersServiceImpl implements AnswersService {
    private final AnswerDao answerDao;

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
