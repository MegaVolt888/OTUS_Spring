package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface AnswerDao {
    ArrayList<Answer> getAllAnswers() throws IOException;
    Answer getAnswerByUUID(UUID uuid) throws IOException;

}
