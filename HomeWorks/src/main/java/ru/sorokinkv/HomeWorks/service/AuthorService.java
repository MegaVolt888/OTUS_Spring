package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

public interface AuthorService {

    void save();

    void update();

    Author findByName();

    void delete();

    List<Author> findAll();
}
