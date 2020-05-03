package ru.sorokinkv.homework04.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class Question {
    private UUID id;
    private String question;
    private ArrayList<UUID> answers;  // задел для многовариантного ответа
}
