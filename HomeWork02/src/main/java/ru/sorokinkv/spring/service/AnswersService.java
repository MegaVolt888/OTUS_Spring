package ru.sorokinkv.spring.service;

import ru.sorokinkv.spring.model.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public interface AnswersService {
    ArrayList<Answer> getAllAnswers() throws IOException;

    Answer getAnswerByUUID(UUID uuid) throws IOException;
}
