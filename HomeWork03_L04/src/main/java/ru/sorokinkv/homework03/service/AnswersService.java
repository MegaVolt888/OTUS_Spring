package ru.sorokinkv.homework03.service;

import ru.sorokinkv.homework03.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface AnswersService {
    ArrayList<Answer> getAllAnswers() throws IOException;

    Answer getAnswerByUUID(UUID uuid) throws IOException;
}
