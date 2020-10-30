package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.dto.BookDTO;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Book;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImplImpl extends AbstractServiceImpl implements BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    GenreService genreService;

    @Override
    public Book createNewBook(@NonNull BookDTO bookDTO){
        Book book = new Book();
        book.setId(0);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(authorService.findById(bookDTO.getAuthor().getId()));
        book.setGenre(genreService.findById(bookDTO.getGenre().getId()));
        return save(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(new Book(0, book.getTitle(), book.getAuthor(), book.getGenre()));

    }

    @Override
    public Book update(BookDTO bookDiff) {
        Book book = findById(bookDiff.getId());
        book.setId(bookDiff.getId());
        book.setTitle(bookDiff.getTitle());
        book.setAuthor(getAuthorById(bookDiff.getAuthor().getId()));
        book.setGenre(getGenreById(bookDiff.getGenre().getId()));
        return bookRepository.save(book);
    }

    @Override
    public boolean delete(Book book) {
        if(existsByTitle(book.getTitle())) {
            bookRepository.deleteById(book.getId());
            return true;
        } else return false;
    }

    @Override
    public boolean deleteById(long id) {
        if(existsById(id)) {
            Book book = findById(id);
            bookRepository.deleteById(book.getId());
            return true;
        }
    return false;
    }

    @Override
    public boolean existsByTitle(String title) {
        return bookRepository.existsByTitle(title);
    }

    @Override
    public boolean existsById(Long id) {
        if (id != null) {
            return bookRepository.existsById(id);
        }
        return false;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        if(existBook(book)) return book;
        return null;
    }

    @Transactional
    @Override
    public List<Book> findByAuthor(Author author) {

        List<Book> books = bookRepository.findByAuthorName(author.getName());
        if ((long) books.size() == 0) {
            return null;
        }
        return books;
    }

    @Transactional
    @Override
    public List<Book> findByGenre(Genre genre) {
        List<Book> books = bookRepository.findByGenreName(genre.getName());
        if ((long) books.size() == 0) {
            return null;
        }
        return books;
    }

    @Override

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    private boolean existBook(Book book) {
        try {
            return bookRepository.existsById(book.getId());
        } catch (NullPointerException ex) {
            return false;
        }
    }
}
