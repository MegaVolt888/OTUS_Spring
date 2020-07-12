package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;
import java.util.Set;

public interface GenreRepositoryJpa {
    long count();

    void save(Genre genre);

    void updateNameById(Genre genre);

    void deleteById(long id);

    Genre findById(long id);

    Genre findByName(String name);

    List<Genre> findAll();

    @Transactional
    Set<Book> getAllBooks(String name);
}
