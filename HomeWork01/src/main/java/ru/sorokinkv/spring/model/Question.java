package ru.sorokinkv.spring.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class Question {
    private final UUID id;
    private final int questinQueue;
    private final String question;
    private final ArrayList<UUID> answers;  // задел для многовариантного ответа
}
