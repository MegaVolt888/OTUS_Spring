package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import ru.sorokinkv.HomeWorks.models.dto.BookDTO;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Book;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;

public interface BookService {

    Book createNewBook(@NonNull BookDTO bookDTO);

    Book findById(Long id);

    Book save(Book book);

    Book update(BookDTO bookDiff);

    boolean delete(Book book);

    boolean deleteById(long id);

    boolean existsByTitle(String title);

    boolean existsById(Long id);

    List<Book> findByGenre(Genre genre);

    List<Book> findAll();

    Book findByTitle(String title);

    List<Book> findByAuthor(Author author);

}
