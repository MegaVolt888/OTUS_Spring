package ru.sorokinkv.homework04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final TestStudent testStudent;

    @ShellMethod(value = "Introduce yourself", key = {"i", "intro"})
    public void intro(@ShellOption(defaultValue = "User") String firstName, @ShellOption(defaultValue = "18") int age) {
        testStudent.intro(firstName, age);
    }

    @ShellMethod(value = "start", key = {"s", "start"})
    @ShellMethodAvailability(value = "isStartTestingAvailable")
    public void startTesting() throws Exception {
        testStudent.testStudent();
    }

}
