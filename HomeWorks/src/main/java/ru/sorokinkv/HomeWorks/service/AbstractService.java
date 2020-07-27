package ru.sorokinkv.HomeWorks.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Genre;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepository;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;
import ru.sorokinkv.HomeWorks.repositories.GenreRepository;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

public abstract class AbstractService {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public IOService ms;

    public String getMessage(String message) {
        ms.showMessage(message);
        return ms.getMessage().toLowerCase();
    }

    public void showMessage(String message) {
        ms.showMessage(message);
    }

    public Author findAuthorByName() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(name);
        if (author == null) {
            throw new RuntimeException(AUTHOR_NOT_FOUND);
        }
        return author;
    }

    public Genre getGenreOrInsert() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            return insertAndReturnGenre(name);
        }
        return genre;
    }

    public Author getAuthorOrInsert() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(name);
        if (author == null) {
            return insertAndReturnAuthor(name);
        }
        return author;
    }

    public Genre findGenreByName() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            throw new RuntimeException(GENRE_NOT_FOUND);
        }
        return genre;
    }

    private Genre insertAndReturnGenre(String name) {
        genreRepository.save(new Genre(name));
        return genreRepository.findByName(name);
    }

    private Author insertAndReturnAuthor(String name) {
        authorRepository.save(new Author(name));
        return authorRepository.findByName(name);
    }
}
