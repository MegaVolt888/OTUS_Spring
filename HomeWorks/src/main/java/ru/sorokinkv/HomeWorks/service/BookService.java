package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookService {
    void save();

    Book findByTitle();

    void update();

    void delete();

    List<Book> findAll();

    List<Book> findByAuthor();

    List<Book> findByGenre();
}
