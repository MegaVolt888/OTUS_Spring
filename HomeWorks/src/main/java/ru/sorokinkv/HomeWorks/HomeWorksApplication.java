package ru.sorokinkv.HomeWorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.sorokinkv.HomeWorks.dao.AuthorDao;
import ru.sorokinkv.HomeWorks.dao.BookDao;
import ru.sorokinkv.HomeWorks.dao.GenreDao;
import ru.sorokinkv.HomeWorks.domain.Book;

@SpringBootApplication
public class HomeWorksApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HomeWorksApplication.class, args);

        BookDao bookDao = context.getBean(BookDao.class);
        AuthorDao authorDao = context.getBean(AuthorDao.class);
        GenreDao genreDao = context.getBean(GenreDao.class);
        System.out.println(authorDao.getAll());
        System.out.println(genreDao.getAll());
        System.out.println(bookDao.getAll());
        System.out.println(authorDao.getAll());
        System.out.println(authorDao.getById("e9ef83e0-3058-4763-a7e8-ce55a40b79a7"));
        Book book = new Book();
        bookDao.insert(book.createBook("Test","Tester","testing"));
        System.out.println(authorDao.getAll());
        System.out.println(genreDao.getAll());
        System.out.println(bookDao.getAll());


    }

}
