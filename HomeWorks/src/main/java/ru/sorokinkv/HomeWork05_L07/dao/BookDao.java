package ru.sorokinkv.HomeWork05_L07.dao;

import ru.sorokinkv.HomeWork05_L07.domain.Book;

import java.util.List;

public interface BookDao {
    int count();

    void insert(Book book);

    List<Book> getAll();

    Book getByTitle(String title);
}
