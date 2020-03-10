package ru.sorokinkv.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.sorokinkv.spring.model.Answer;

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

@Component
public class AnswerDaoImpl implements AnswerDao {

    @Value("${data.answers.file}")
    private String answers;

    private Function<String, Answer> mapToItem = (line) -> {
        if (line.length() > 0) {
            ArrayList<UUID> answerArrayList = new ArrayList<>();
            String[] p = line.split(";");
            Answer item = new Answer();
            item.setAnswerId(UUID.fromString(p[0]));
            item.setAnswer(p[1]);
            return item;
        }
        return null;
    };

    public ArrayList<Answer> getAllAnswers() throws IOException {
        List<Answer> inputList;
        InputStream answersIS = this.getClass().getClassLoader().getResourceAsStream(answers);
        BufferedReader br = new BufferedReader(new InputStreamReader(answersIS));
        inputList = br.lines().skip(1).map(mapToItem).filter(a -> Objects.nonNull(a)).collect(Collectors.toList());
        br.close();
        return new ArrayList<Answer>(inputList);
    }

    @Override
    public Answer getAnswerByUUID(UUID uuid) throws IOException {
        ArrayList<Answer> answerList = this.getAllAnswers();
        return answerList.stream().filter(id -> id.getAnswerId().equals(uuid)).findFirst().get();
    }
/*
    public void setAnswers(String answers) {
        this.answers = answers;
    }*/
}
