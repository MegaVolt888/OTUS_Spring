package ru.sorokinkv.spring.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class Question {
    private UUID id;
    private int questinQueue;
    private String question;
    private ArrayList<UUID> answers;  // задел для многовариантного ответа


}
