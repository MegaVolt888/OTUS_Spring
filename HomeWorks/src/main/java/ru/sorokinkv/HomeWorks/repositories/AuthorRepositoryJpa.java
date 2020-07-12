package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;
import java.util.Set;

public interface AuthorRepositoryJpa {
    long count();

    void save(Author author);

    void updateName(Author author);

    void deleteById(long id);

    Author findById(long id);

    Author findByName(String name);

    List<Author> findAll();

    Set<Book> getAllBooks(String name);
}
