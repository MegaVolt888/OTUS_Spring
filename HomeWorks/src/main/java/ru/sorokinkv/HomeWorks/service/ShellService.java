package ru.sorokinkv.HomeWorks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepositoryJpa;
import ru.sorokinkv.HomeWorks.repositories.BookRepositoryJpa;
import ru.sorokinkv.HomeWorks.repositories.GenreRepositoryJpa;

import java.util.List;
import java.util.Set;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final BookRepositoryJpa bookRepository;
    private final AuthorRepositoryJpa authorRepository;
    private final GenreRepositoryJpa genreRepository;
    private final IOService messageService;

    @ShellMethod(value = "Create book", key = {"cb", "create book"})
    public void createBook() {
        String title = getMessage(ENTER_BOOK_TITLE);
        bookRepository.save(new Book(0, title, getAuthor(), getGenre()));
        messageService.showMessage("Добавлена книга: " + title);
    }

    @ShellMethod(value = "Search books by title", key = {"sbbt", "search book by title"})
    public Book searchBookByName() {
        messageService.showMessage(ENTER_BOOK_TITLE);
        return bookRepository.findByTitle(messageService.getMessage());
    }

    @ShellMethod(value = "Search books by author", key = {"sbba", "search books by author"})
    public Set<Book> searchBookByAuthor() {
        messageService.showMessage(ENTER_AUTHOR_NAME);
        return authorRepository.getAllBooks(messageService.getMessage());
    }

    @ShellMethod(value = "Search books by genre", key = {"sbbg", "search books by genre"})
    public Set<Book> searchBookByGenre() {
        messageService.showMessage(ENTER_GENRE_NAME);
        return genreRepository.getAllBooks(messageService.getMessage());
    }

    @ShellMethod(value = "Update book", key = {"ub", "update book"})
    public void updateBook() {
        String title = getMessage(ENTER_BOOK_TITLE);
        Book book = bookRepository.findByTitle(title);
        bookRepository.updateBookById(new Book(book.getId(), title, getAuthor(), getGenre()));
        messageService.showMessage("Книга успешно изменена: " + title);
    }

    @ShellMethod(value = "Delete book by title", key = {"db", "delete book"})
    public void deleteBook() {
        messageService.showMessage(ENTER_DELETE_BOOK_TITLE);
        String title = messageService.getMessage();
        Book book = bookRepository.findByTitle(title);
        bookRepository.deleteBook(book);
        messageService.showMessage("Книга \"" + title + "\" успешно удалена.");
    }

    @ShellMethod(value = "Show all books", key = {"all", "all books"})
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @ShellMethod(value = "Insert author", key = {"ca"})
    private void createAuthor() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = new Author(0, name, null);
        authorRepository.save(author);
    }

    @ShellMethod(value = "Update author", key = {"ua", "update author"})
    public void updateAuthor() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(name);
        String changeName = getMessage(ENTER_NEW_AUTHOR_FULLNAME);
        authorRepository.updateName(new Author(author.getId(), changeName, null));
        messageService.showMessage("Автор успешно изменен: " + changeName);
    }

    @ShellMethod(value = "Search authors by name", key = {"sabn", "author name"})
    public Author getAuthorByName() {
        messageService.showMessage(ENTER_AUTHOR_NAME);
        String value = messageService.getMessage();
        return authorRepository.findByName(value);
    }

    @ShellMethod(value = "Delete author", key = {"da", "delete author", "del auth"})
    private void deleteAuthor() {
        messageService.showMessage(ENTER_AUTHOR_NAME);
        String value = messageService.getMessage();
        Author author = authorRepository.findByName(value);
        authorRepository.deleteAuthor(author);
        messageService.showMessage("Автор \"" + value + "\" " + DELETED_SUCCESSFULLY);
    }

    @ShellMethod(value = "Show all authors", key = {"aa", "authors"})
    public List<Author> getAllAuthors() {

        return authorRepository.findAll();
    }


    @ShellMethod(value = "Search genres by name", key = {"sgbn", "genre name"})
    public Genre getGenreByName() {
        messageService.showMessage(ENTER_GENRE_NAME);
        String value = messageService.getMessage();
        return genreRepository.findByName(value);
    }

    @ShellMethod(value = "Delete genre", key = {"dg", "delete genre", "del genre"})
    public void deleteGenre() {
        messageService.showMessage(ENTER_GENRE_NAME);
        String value = messageService.getMessage();
        Genre genre = genreRepository.findByName(value);
        genreRepository.deleteGenre(genre);
        messageService.showMessage("Жанр \"" + value + "\" " + DELETED_SUCCESSFULLY);
    }

    @ShellMethod(value = "Show all genres", key = {"ag", "genres"})
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    private String getMessage(String message) {
        messageService.showMessage(message);
        return messageService.getMessage();
    }

    private Genre getGenre() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre;
        try {
            genre = genreRepository.findByName(name);
        } catch (EmptyResultDataAccessException e) {
            return insertAndReturnGenre(name);
        }
        return genre;
    }

    private Author getAuthor() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author;
        try {
            author = authorRepository.findByName(name);
        } catch (EmptyResultDataAccessException e) {
            return insertAndReturnAuthor(name);
        }
        return author;
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
