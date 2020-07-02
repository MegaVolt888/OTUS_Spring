package ru.sorokinkv.HomeWorks.dao;

import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookDao {
    int count();

    void insert(Book book);

    List<Book> getAll();

    Book getByTitle(String title);
}
