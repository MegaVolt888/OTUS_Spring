package ru.sorokinkv.spring.service;

import ru.sorokinkv.spring.model.Answer;
import ru.sorokinkv.spring.model.Question;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TestStudentImpl implements TestStudent {
    private static QuestionsService questionsService;
    private static AnswersService answersService;

    private static void showResults(HashMap hm, boolean correct) {
        String color = "\u001B[31m";
        String resetColor = "\u001B[0m";
        if (correct) color = "\u001B[32m";
        String finalColor = color;
        hm.forEach((k, v) -> {
            Question question = (Question) k;
            ArrayList<UUID> arrayList = (ArrayList<UUID>) v;
            System.out.print("\u001B[36mВопрос: " + resetColor);
            System.out.println(question.getQuestion());
            System.out.println(finalColor + "Ваши ответы: " + resetColor);
            for (UUID uuid : arrayList) {
                try {
                    System.out.println("\t" + finalColor + answersService.getAnswerByUUID(uuid).getAnswer() + resetColor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!correct) {
                System.out.println("\u001B[32mПравильные ответы: " + resetColor);
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
    public void testStudent() {
        ArrayList<Question> questions = questionsService.getAllQuestion();
        ArrayList<Answer> answers = null;
        try {
            answers = answersService.getAllAnswers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = in.nextLine();
        if (userName.length() == 0) userName = "User" + new Date().getTime();
        System.out.println(userName + ", введите ваш возраст: ");
        int age = in.nextInt();
        in.nextLine();
        HashMap correctAnswer = new HashMap();
        HashMap inCorrectAnswer = new HashMap();
        for (Question question : questions) {
            boolean inputCheck = true;
            while (inputCheck) {
                System.out.print("\u001B[36m\u001b[4mВопрос:\u001B[0m ");
                System.out.println("\u001B[36m" + question.getQuestion());
                System.out.println("\u001B[0mВарианты ответов: ");
                for (int i = 0; i < answers.size(); i++) {
                    System.out.print((i + 1) + ": ");
                    System.out.println(answers.get(i).getAnswer());
                }
                System.out.print("Выберите номер верного ответа (можно ввести несколько вариантов через \",\"): ");
                String input = in.nextLine();
                try {
                    Integer.parseInt(input.replaceAll(" ", "").replaceAll(",", ""));
                    inputCheck = false;
                } catch (Exception ex) {
                    System.out.println(" \u001B[7m\u001B[31mВНИМАНИЕ!!! Вводить можно только цифры и запятые.\u001B[0m");
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
            System.out.println("\u001B[7m\u001B[32m\t " + userName + ", Вы правильно ответили на следующие вопросы:\t\u001B[0m");
            showResults(correctAnswer, true);
        }
        if (inCorrectAnswer.size() > 0) {
            System.out.println("\u001B[7m\u001B[31m\t" + userName + ", Вы неправильно ответили на следующие вопросы:\t\u001B[0m");
            showResults(inCorrectAnswer, false);
        }
    }

    public void setQuestionsS(QuestionsServiceImpl questionsS) {
        questionsService = questionsS;
    }

    public void setAnswersS(AnswersServiceImpl answersS) {
        answersService = answersS;
    }
}
