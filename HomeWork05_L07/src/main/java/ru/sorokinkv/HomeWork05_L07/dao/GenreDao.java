package ru.sorokinkv.HomeWork05_L07.dao;

import ru.sorokinkv.HomeWork05_L07.domain.Genre;

import java.util.List;

public interface GenreDao {
    int count();

    void insert(Genre genre);

    Genre getByName(String genreName);

    Genre getById(String uuid);

    List<Genre> getAll();
}
