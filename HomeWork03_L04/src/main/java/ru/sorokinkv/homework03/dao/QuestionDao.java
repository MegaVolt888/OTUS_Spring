package ru.sorokinkv.homework03.dao;

import ru.sorokinkv.homework03.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface QuestionDao {
    ArrayList<Question> getAllQuestions() throws IOException;
}
