package ru.sorokinkv.HomeWorks.dao;

import ru.sorokinkv.HomeWorks.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();

    void insert(Author author);

    Author getByName(String authorName);

    Author getById(String uuid);

    List<Author> getAll();
}
