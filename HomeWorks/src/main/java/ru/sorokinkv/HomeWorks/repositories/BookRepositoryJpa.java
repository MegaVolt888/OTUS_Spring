package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookRepositoryJpa {
    int count();

    Book save(Book book);

    List<Book> findAll();

    Book findByTitle(String title);
}
