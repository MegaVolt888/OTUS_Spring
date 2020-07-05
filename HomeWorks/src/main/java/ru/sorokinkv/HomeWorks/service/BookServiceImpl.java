package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class BookServiceImpl extends AbstractService implements BookService {

    @Override
    public void save() {
        String title = getMessage(ENTER_BOOK_TITLE);
        Author author = getAuthor();
        bookRepository.save(new Book(0, title, author, getGenre()));
        showMessage(BOOK_SAVE + " " + title);
    }

    @Override
    public void update() {
        Book book = findByTitle();
        bookRepository.save(new Book(book.getId(), book.getTitle(), getAuthor(), getGenre()));
        showMessage(BOOK_UPDATE + " " + book.getTitle());
    }

    @Override
    public void delete() {
        Book book = findByTitle();
        bookRepository.deleteById(book.getId());
        showMessage(BOOK_DELETED_SUCCESS);
    }

    @Override
    public Book findByTitle() {
        String title = getMessage(ENTER_BOOK_TITLE);
        Book book = bookRepository.findByTitle(title);
        existBook(book);
        return book;
    }

    @Override
    public List<Book> findByAuthor() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        List<Book> books = bookRepository.findByAuthor(name);
        if ((long) books.size() == 0) {
            throw new RuntimeException(BOOK_NOT_FOUND);
        }
        return books;
    }

    @Override
    public List<Book> findByGenre() {
        String name = getMessage(ENTER_GENRE_NAME);
        List<Book> books = bookRepository.findByGenre(name);
        if ((long) books.size() == 0) {
            throw new RuntimeException(BOOK_NOT_FOUND);
        }
        return books;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    private void existBook(Book book) {
        try {
            bookRepository.existsById(book.getId());
        } catch (NullPointerException ex) {
            throw new RuntimeException(BOOK_NOT_FOUND);
        }
    }

    public Genre getGenre() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            return insertAndReturnGenre(name);
        }
        return genre;
    }

    public Author getAuthor() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(name);
        if (author == null) {
            return insertAndReturnAuthor(name);
        }
        return author;
    }

    private Genre insertAndReturnGenre(String name) {
        genreRepository.save(new Genre(0, name));
        return genreRepository.findByName(name);
    }

    private Author insertAndReturnAuthor(String name) {
        authorRepository.save(new Author(0, name));
        return authorRepository.findByName(name);
    }
}
