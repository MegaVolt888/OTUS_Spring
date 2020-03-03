package ru.sorokinkv.spring.model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionTest {
    private static Question question = new Question();


    @BeforeAll
    static void createQuestion(){
        question.setQuestion("Test");
        question.setId(UUID.randomUUID());
        ArrayList<UUID> arrayList = new ArrayList<>();
        arrayList.add(UUID.randomUUID());
        question.setAnswers(arrayList);
    }

    @Order(1)
    @Test
    @DisplayName("Test getQuestionId")
    void getQuestionId() {
        Assertions.assertNotNull(question.getId(),"Tested");
    }

    @Order(2)
    @Test
    @DisplayName("Test getQuestion")
    void getQuestion() {
        Assertions.assertEquals("Test",question.getQuestion(),"Tested");
    }

    @Order(3)
    @Test
    @DisplayName("Test setQuestionId")
    void setQuestionId() {
        UUID uuid = UUID.randomUUID();
        question.setId(uuid);
        Assertions.assertEquals(uuid,question.getId(),"Tested");
    }

    @Order(4)
    @Test
    @DisplayName("Test setQuestion")
    void setQuestion() {
        question.setQuestion("Tested");
        Assertions.assertEquals("Tested",question.getQuestion(),"Tested");
    }

    @Order(5)
    @Test
    @DisplayName("Test getAnswers")
    void getAnswers() {
        Assertions.assertNotNull(question.getAnswers(),"Tested");
    }

    @Order(6)
    @Test
    @DisplayName("Test setAnswers")
    void setAnswers() {
        ArrayList<UUID> arrayList = new ArrayList<>();
        arrayList.add(UUID.randomUUID());
        question.setAnswers(arrayList);

        Assertions.assertEquals(arrayList,question.getAnswers(),"Tested");
    }
}