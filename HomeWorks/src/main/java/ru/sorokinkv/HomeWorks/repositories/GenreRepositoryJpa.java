package ru.sorokinkv.HomeWorks.repositories;

import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

public interface GenreRepositoryJpa {
    int count();

    Genre save(Genre genre);

    Genre findByName(String genreName);

    Genre findById(String uuid);

    List<Genre> findAll();
}
