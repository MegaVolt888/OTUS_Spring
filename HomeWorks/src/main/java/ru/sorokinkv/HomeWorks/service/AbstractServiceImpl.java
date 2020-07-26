package ru.sorokinkv.HomeWorks.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Genre;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepository;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;
import ru.sorokinkv.HomeWorks.repositories.GenreRepository;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

public abstract class AbstractServiceImpl implements AbstractService{

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public IOService ms;

    @Override
    public String getMessage(String message) {
        ms.showMessage(message);
        return ms.getMessage().toLowerCase();
    }

    @Override
    public void showMessage(String message) {
        ms.showMessage(message);
    }

    @Override
    public Author findAuthorByName() {
        String fullname = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(fullname);
        if (author == null) {
            throw new RuntimeException(AUTHOR_NOT_FOUND);
        }
        return author;
    }

    @Override
    public Genre getGenreOrInsert() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            return insertAndReturnGenre(name);
        }
        return genre;
    }

    @Override
    public Author getAuthorOrInsert() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(name);
        if (author == null) {
            return insertAndReturnAuthor(name);
        }
        return author;
    }

    @Override
    public Genre findGenreByName() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            throw new RuntimeException(GENRE_NOT_FOUND);
        }
        return genre;
    }

    private Genre insertAndReturnGenre(String name) {
        genreRepository.save(new Genre(0, name, null));
        return genreRepository.findByName(name);
    }

    private Author insertAndReturnAuthor(String name) {
        authorRepository.save(new Author(0, name, null));
        return authorRepository.findByName(name);
    }
}
