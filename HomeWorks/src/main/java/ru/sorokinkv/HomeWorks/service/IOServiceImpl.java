package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return scanner.nextLine();
    }
}
