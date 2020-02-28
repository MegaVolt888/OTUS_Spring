package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionDao {
    List<Question> getAllQuestions();
    ArrayList<Question> setQuestionCorrect(ArrayList correctQuestionList);
}
