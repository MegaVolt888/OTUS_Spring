package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class BookServiceImpl extends AbstractService implements BookService {

    @Override
    public void save() {
        String title = getMessage(ENTER_BOOK_TITLE);
        Author author = getAuthorOrInsert();
        bookRepository.save(new Book(0, title, author, getGenreOrInsert()));
        showMessage(BOOK_SAVE + " " + title);
    }

    @Override
    public void update() {
        showMessage(ENTER_BOOK_TO_UPDATE);
        Book book = findByTitle();
        bookRepository.save(new Book(book.getId(), book.getTitle(), getAuthorOrInsert(), getGenreOrInsert()));
        showMessage(BOOK_UPDATE + " " + book.getTitle());
    }

    @Override
    public void delete() {
        showMessage(ENTER_BOOK_TO_DELETE);
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
        String fullname = getMessage(ENTER_AUTHOR_NAME);
        List<Book> books = bookRepository.findByAuthorName(fullname);
        if ((long) books.size() == 0) {
            throw new RuntimeException(BOOK_NOT_FOUND);
        }
        return books;
    }

    @Override
    public List<Book> findByGenre() {
        String name = getMessage(ENTER_GENRE_NAME);
        List<Book> books = bookRepository.findByGenreName(name);
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
}
