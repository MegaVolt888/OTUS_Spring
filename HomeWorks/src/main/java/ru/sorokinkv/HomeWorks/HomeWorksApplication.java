package ru.sorokinkv.HomeWorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepositoryJpa;
import ru.sorokinkv.HomeWorks.repositories.BookRepositoryJpa;
import ru.sorokinkv.HomeWorks.repositories.GenreRepositoryJpa;
import ru.sorokinkv.HomeWorks.models.Book;

@SpringBootApplication
public class HomeWorksApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HomeWorksApplication.class, args);

        BookRepositoryJpa bookRepositoryJpa = context.getBean(BookRepositoryJpa.class);
        AuthorRepositoryJpa authorRepositoryJpa = context.getBean(AuthorRepositoryJpa.class);
        GenreRepositoryJpa genreRepositoryJpa = context.getBean(GenreRepositoryJpa.class);
        System.out.println(authorRepositoryJpa.findAll());
        System.out.println(genreRepositoryJpa.findAll());
        System.out.println(bookRepositoryJpa.findAll());
        System.out.println(authorRepositoryJpa.findAll());
        System.out.println(authorRepositoryJpa.findById("e9ef83e0-3058-4763-a7e8-ce55a40b79a7"));
        Book book = new Book();
//        bookDao.insert(book.createBook("Test","Tester","testing"));
        System.out.println(authorRepositoryJpa.findAll());
        System.out.println(genreRepositoryJpa.findAll());
        System.out.println(bookRepositoryJpa.findAll());


    }

}
