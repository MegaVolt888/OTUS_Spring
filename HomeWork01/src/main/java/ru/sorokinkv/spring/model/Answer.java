package ru.sorokinkv.spring.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Answer {
    private final UUID answerId; // задел для интеграции с БД
    private final String answer;
}
