package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

public interface GenreRepositoryJpa {
    long count();

    void save(Genre genre);

    void updateNameById(Genre genre);

    void deleteById(long id);

    Genre findById(long id);

    Genre findByName(String name);

    List<Genre> findAll();
}
