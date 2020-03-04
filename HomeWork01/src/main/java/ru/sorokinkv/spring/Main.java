package ru.sorokinkv.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sorokinkv.spring.service.TestStudent;

import java.io.IOException;


public class Main {


    public static void main(String[] args) throws IOException {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        final TestStudent testStudent = context.getBean(TestStudent.class);
        testStudent.testStudent();
    }

}