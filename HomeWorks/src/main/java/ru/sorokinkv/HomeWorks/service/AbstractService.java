package ru.sorokinkv.HomeWorks.service;

import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Genre;

public interface AbstractService {

    String getMessage(String message);

    void showMessage(String message);

    Author findAuthorByName();

    Genre getGenreOrInsert();

    Author getAuthorOrInsert();

    Genre findGenreByName();
}
