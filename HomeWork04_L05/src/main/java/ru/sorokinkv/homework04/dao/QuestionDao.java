package ru.sorokinkv.homework04.dao;

import ru.sorokinkv.homework04.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface QuestionDao {
    ArrayList<Question> getAllQuestions() throws IOException;
}
