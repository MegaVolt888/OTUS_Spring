package ru.sorokinkv.HomeWorks.dao;

import ru.sorokinkv.HomeWorks.domain.Genre;

import java.util.List;

public interface GenreDao {
    int count();

    void insert(Genre genre);

    Genre getByName(String genreName);

    Genre getById(String uuid);

    List<Genre> getAll();
}
