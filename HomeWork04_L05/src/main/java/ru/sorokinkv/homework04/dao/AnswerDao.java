package ru.sorokinkv.homework04.dao;

import ru.sorokinkv.homework04.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface AnswerDao {
    ArrayList<Answer> getAllAnswers() throws IOException;

    Answer getAnswerByUUID(UUID uuid) throws IOException;

}
