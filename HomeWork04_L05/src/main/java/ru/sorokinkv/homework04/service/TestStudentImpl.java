package ru.sorokinkv.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.sorokinkv.homework04.config.LanguageConfig;
import ru.sorokinkv.homework04.model.Answer;
import ru.sorokinkv.homework04.model.Question;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TestStudentImpl implements TestStudent {
    private final MessageSource messageSource;
    private final Locale locale;
    private static String name;
    private static int age;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private AnswersService answersService;

    public TestStudentImpl(MessageSource messageSource, LanguageConfig languageConfig) {
        this.messageSource = messageSource;
        locale = new Locale(languageConfig.getLanguageTag());
    }


    private void showResults(HashMap hm, boolean correct) {
        String color = "\u001B[31m";
        String resetColor = "\u001B[0m ";
        if (correct) color = "\u001B[32m";
        String finalColor = color;
        hm.forEach((k, v) -> {
            Question question = (Question) k;
            ArrayList<UUID> arrayList = (ArrayList<UUID>) v;
            System.out.print("\u001B[36m" + messageSource.getMessage("message.question", null, locale) + ":" + resetColor);
            System.out.println(question.getQuestion());
            System.out.println(finalColor + messageSource.getMessage("message.answers.your", null, locale) + resetColor);
            for (UUID uuid : arrayList) {
                try {
                    System.out.println("\t" + finalColor + answersService.getAnswerByUUID(uuid).getAnswer() + resetColor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!correct) {
                System.out.println("\u001B[32m" + messageSource.getMessage("message.answers", null, locale) + resetColor);
                for (UUID uuid : question.getAnswers()) {
                    try {
                        System.out.println("\t \u001B[32m" + answersService.getAnswerByUUID(uuid).getAnswer() + resetColor);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void intro(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(messageSource.getMessage("message.welcome", new String[]{name, String.valueOf(age)}, locale) + ": ");
    }

    @Override
    public void testStudent() {
        ArrayList<Question> questions = questionsService.getAllQuestion();
        ArrayList<Answer> answers = null;
        Scanner in = new Scanner(System.in);
        try {
            answers = answersService.getAllAnswers();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap correctAnswer = new HashMap();
        HashMap inCorrectAnswer = new HashMap();
        for (Question question : questions) {
            boolean inputCheck = true;
            while (inputCheck) {
                System.out.print("\u001B[36m\u001b[4m" + messageSource.getMessage("message.question", null, locale) + ":\u001B[0m ");
                System.out.println("\u001B[36m" + question.getQuestion());
                System.out.println("\u001B[0m" + messageSource.getMessage("message.answers.variants", null, locale) + ": ");
                for (int i = 0; i < answers.size(); i++) {
                    System.out.print((i + 1) + ": ");
                    System.out.println(answers.get(i).getAnswer());
                }
                System.out.print(messageSource.getMessage("message.input.more", null, locale) + "\",\"): ");
                String input = in.nextLine();
                try {
                    Integer.parseInt(input.replaceAll(" ", "").replaceAll(",", ""));
                    inputCheck = false;
                } catch (Exception ex) {
                    System.out.println(" \u001B[7m\u001B[31m" + messageSource.getMessage("message.input.error", null, locale) + ".\u001B[0m");
                    inputCheck = true;
                    continue;
                }
                String[] inputA = input.replaceAll(" ", "").split(",");
                ArrayList<Answer> finalAnswers = answers;
                ArrayList<UUID> inputAnswerUUID = new ArrayList<UUID>(Arrays.stream(inputA).map(s -> {
                    UUID uuid = finalAnswers.get(Integer.parseInt(s) - 1).getAnswerId();
                    return uuid;
                }).collect(Collectors.toList()));

                boolean correctFlag = false;
                for (UUID uuid : inputAnswerUUID) {
                    if (question.getAnswers().contains(uuid) && question.getAnswers().size() == inputAnswerUUID.size()) {
                        correctFlag = true;
                    } else
                        correctFlag = false;
                }
                if (correctFlag) {
                    correctAnswer.put(question, inputAnswerUUID);
                } else inCorrectAnswer.put(question, inputAnswerUUID);
            }
        }

        if (correctAnswer.size() > 0) {
            System.out.println("\u001B[7m\u001B[32m\t " + name + ", " + messageSource.getMessage("message.answers.correct", null, locale) + ":\t\u001B[0m");
            showResults(correctAnswer, true);
        }
        if (inCorrectAnswer.size() > 0) {
            System.out.println("\u001B[7m\u001B[31m\t" + name + ", " + messageSource.getMessage("message.answers.incorrect", null, locale) + ":\t\u001B[0m");
            showResults(inCorrectAnswer, false);
        }
    }
}
