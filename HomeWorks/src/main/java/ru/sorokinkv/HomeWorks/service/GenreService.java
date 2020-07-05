package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

public interface GenreService {
    Genre foundGenreByName();

    void delete();

    List<Genre> findAll();
}
