package ru.sorokinkv.spring.dao;

import ru.sorokinkv.spring.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;


public class QuestionDaoImpl implements QuestionDao {
    String questions;
    private Function<String, Question> mapToItem = (line) -> {
        if (line.length() > 0) {
            ArrayList<UUID> answerArrayList = new ArrayList<>();
            String[] p = line.split(";");// a CSV has comma separated lines

            Question item = new Question();
            item.setId(UUID.fromString(p[0]));//<-- this is the first column in the csv file
            item.setQuestion(p[1]);
            for (int i = 2; i < p.length; i++) {
                answerArrayList.add(UUID.fromString(p[i]));
            }
            item.setAnswers(answerArrayList);
            return item;
        }
        return null;
    };

    public ArrayList<Question> getAllQuestions() throws IOException {
        List<Question> inputList;
        InputStream questionsIS = this.getClass().getClassLoader().getResourceAsStream(questions);
        BufferedReader br = new BufferedReader(new InputStreamReader(questionsIS));
        inputList = br.lines().skip(1).map(mapToItem).filter(a -> Objects.nonNull(a)).collect(Collectors.toList());
        br.close();
        //System.out.println(inputList);
        return new ArrayList<Question>(inputList);
    }

    public ArrayList<Question> setQuestionCorrect(ArrayList correctQuestionList) {
        return null;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

}
