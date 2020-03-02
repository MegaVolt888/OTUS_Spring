package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Answer;

import java.util.ArrayList;
import java.util.UUID;

public interface AnswerDao {
    ArrayList<Answer> getAllAnswers();
    Answer getAnswerByUUID(UUID uuid);

}
