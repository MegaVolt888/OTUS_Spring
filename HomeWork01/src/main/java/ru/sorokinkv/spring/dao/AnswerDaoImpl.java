package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Answer;

import java.util.ArrayList;
import java.util.UUID;

public class AnswerDaoImpl implements AnswerDao{
    String answers;

    public ArrayList<Answer> getAllAnswers() {
        System.out.println(this.getClass().getClassLoader().getResourceAsStream(answers));
        return null;
    }

    @Override
    public Answer getAnswerByUUID(UUID uuid) {
        return null;
    }


    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
