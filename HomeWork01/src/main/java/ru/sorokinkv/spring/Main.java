package ru.sorokinkv.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sorokinkv.spring.model.Answer;
import ru.sorokinkv.spring.model.Question;
import ru.sorokinkv.spring.service.AnswersService;
import ru.sorokinkv.spring.service.QuestionsService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionsService questionsService = context.getBean(QuestionsService.class);
        ArrayList<Question> questions = questionsService.getAllQuestion();
        System.out.println(questions);
        AnswersService answersService = context.getBean(AnswersService.class);
        ArrayList<Answer> answers = answersService.getAllAnswers();
        //   System.out.println(answers);


    }
}
