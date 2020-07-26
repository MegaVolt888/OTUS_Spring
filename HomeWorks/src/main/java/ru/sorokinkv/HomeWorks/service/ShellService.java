package ru.sorokinkv.HomeWorks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @ShellMethod(value = "Create book", key = {"cb", "create book"})
    public void createBook() {
        bookService.save();
    }

    @ShellMethod(value = "Search books by title", key = {"sbbt", "search book by title"})
    public Book searchBookByName() {
        return bookService.findByTitle();
    }

    @ShellMethod(value = "Search books by author", key = {"sbba", "search books by author"})
    public List<Book> searchBookByAuthor() {
        return bookService.findByAuthor();
    }

    @ShellMethod(value = "Search books by genre", key = {"sbbg", "search books by genre"})
    public List<Book> searchBookByGenre() {
        return bookService.findByGenre();
    }

    @ShellMethod(value = "Update book", key = {"ub", "update book"})
    public void updateBook() {
        bookService.update();
    }

    @ShellMethod(value = "Delete book by title", key = {"db", "delete book"})
    public void deleteBook() {
        bookService.delete();
    }

    @ShellMethod(value = "Show all books", key = {"all", "all books"})
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }


    @ShellMethod(value = "Insert author", key = {"ca"})
    private void createAuthor() {
        authorService.save();
    }

    @ShellMethod(value = "Update author", key = {"ua", "update author"})
    public void updateAuthor() {
        authorService.update();
    }

    @ShellMethod(value = "Search authors by name", key = {"sabn", "author name"})
    public Author getAuthorByName() {
        return authorService.findByName();
    }

    @ShellMethod(value = "Delete author", key = {"da", "delete author", "del auth"})
    private void deleteAuthor() {
        authorService.delete();
    }

    @ShellMethod(value = "Show all authors", key = {"aa", "authors"})
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }


    @ShellMethod(value = "Search genres by name", key = {"sgbn", "genre name"})
    public Genre getGenreByName() {
        return genreService.foundByName();
    }

    @ShellMethod(value = "Delete genre", key = {"dg", "delete genre", "del genre"})
    public void deleteGenre() {
        genreService.delete();
    }

    @ShellMethod(value = "Show all genres", key = {"ag", "genres"})
    public List<Genre> getAllGenres() {
        return genreService.findAll();
    }
}
