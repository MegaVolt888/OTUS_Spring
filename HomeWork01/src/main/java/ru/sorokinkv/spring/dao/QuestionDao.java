package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface QuestionDao {
    ArrayList<Question> getAllQuestions() throws IOException;
}
