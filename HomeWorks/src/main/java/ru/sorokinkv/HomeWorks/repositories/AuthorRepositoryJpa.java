package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

public interface AuthorRepositoryJpa {
    long count();

    void save(Author author);

    void updateName(Author author);

    void deleteById(long id);

    Author findById(long id);

    Author findByName(String fullname);

    List<Author> findAll();
}
