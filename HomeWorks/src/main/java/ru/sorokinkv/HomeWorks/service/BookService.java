package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookService {
    void save();

    Book findByTitle();

    List<Book> findByAuthor();

    List<Book> findByGenre();

    void update();

    void delete();

    List<Book> findAll();
}
