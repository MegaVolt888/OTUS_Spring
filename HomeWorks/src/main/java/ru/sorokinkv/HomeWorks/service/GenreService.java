package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

public interface GenreService {
    void save();

    void update();

    void delete();

    Genre foundByName();

    List<Genre> findAll();
}
