package ru.sorokinkv.homework03.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.homework03.dao.AnswerDao;
import ru.sorokinkv.homework03.model.Answer;

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
