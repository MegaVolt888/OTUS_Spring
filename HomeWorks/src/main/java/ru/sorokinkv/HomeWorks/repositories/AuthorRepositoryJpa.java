package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

public interface AuthorRepositoryJpa {
    int count();

    Author save(Author author);

    Author findByName(String authorName);

    Author findById(String uuid);

    List<Author> findAll();
}
