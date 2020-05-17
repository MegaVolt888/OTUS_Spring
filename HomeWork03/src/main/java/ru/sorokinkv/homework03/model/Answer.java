package ru.sorokinkv.homework03.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Answer {
    private UUID answerId; // задел для интеграции с БД
    private String answer;
}
