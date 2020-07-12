package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookRepositoryJpa {
    long count();

    void save(Book book);

    void updateBookById(Book book);

    void deleteBook(Book book);

    Book findById(long id);

    Book findByTitle(String title);

    List<Book> findAll();
}
