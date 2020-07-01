package ru.sorokinkv.HomeWork05_L07.dao;

import ru.sorokinkv.HomeWork05_L07.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();

    void insert(Author author);

    Author getByName(String authorName);

    Author getById(String uuid);

    List<Author> getAll();
}
