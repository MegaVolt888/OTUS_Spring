package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

public interface AbstractService {

    Author findAuthorByName(String name);

    Genre findGenreByName(String name);

    Genre getGenreOrInsert(String name);

    Author getAuthorOrInsert(String name);
}
