package ru.sorokinkv.HomeWorks.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Genre;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepository;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;
import ru.sorokinkv.HomeWorks.repositories.GenreRepository;

public abstract class AbstractServiceImpl implements AbstractService{

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public GenreRepository genreRepository;


    @Override
    public Author findAuthorByName(String name) {
        Author author = authorRepository.findByName(name);
        if (author == null) {
            throw new RuntimeException("AUTHOR_NOT_FOUND");
        }
        return author;
    }

    @Override
    public Genre getGenreOrInsert(String name) {
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            return insertAndReturnGenre(name);
        }
        return genre;
    }

    @Override
    public Author getAuthorOrInsert(String name) {
        Author author = authorRepository.findByName(name);
        if (author == null) {
            return insertAndReturnAuthor(name);
        }
        return author;
    }


    public Author getAuthorById(Long id){
        return authorRepository.findById(id).get();
    }

    @Override
    public Genre findGenreByName(String name) {
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            throw new RuntimeException("GENRE_NOT_FOUND");
        }
        return genre;
    }
    public Genre getGenreById(Long id){
        return genreRepository.findById(id).get();
    }

    private Genre insertAndReturnGenre(String name) {
        genreRepository.save(new Genre(0, name, null));
        return genreRepository.findByName(name);
    }

    private Author insertAndReturnAuthor(String name) {
        authorRepository.save(new Author(0, name,null));
        return authorRepository.findByName(name);
    }
}
