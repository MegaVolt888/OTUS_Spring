package ru.sorokinkv.spring.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AnswerTest {
    private static Answer answer = new Answer();


    @BeforeAll
    static void createAnswer(){
        answer.setAnswer("Test");
        answer.setAnswerId(UUID.randomUUID());
    }

    @Order(1)
    @Test
    @DisplayName("Test getAnswerId")
    void getAnswerId() {
        Assertions.assertNotNull(answer.getAnswerId(),"Tested");
    }

    @Order(2)
    @Test
    @DisplayName("Test getAnswer")
    void getAnswer() {
        Assertions.assertEquals("Test",answer.getAnswer(),"Tested");
    }

    @Order(3)
    @Test
    @DisplayName("Test setAnswerId")
    void setAnswerId() {
        UUID uuid = UUID.randomUUID();
        answer.setAnswerId(uuid);
        Assertions.assertEquals(uuid,answer.getAnswerId(),"Tested");
    }

    @Order(4)
    @Test
    @DisplayName("Test setAnswer")
    void setAnswer() {
        answer.setAnswer("Tested");
        Assertions.assertEquals("Tested",answer.getAnswer(),"Tested");
    }
}