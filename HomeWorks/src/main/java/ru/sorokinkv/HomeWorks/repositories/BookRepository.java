package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {

    long count();

    Book save(Book book);

    void deleteById(String id);

    Book findById(String id);

    Book findByTitle(String title);

    List<Book> findByAuthorName(String name);

    List<Book> findByAuthorId(String id);

    List<Book> findByGenreName(String name);

    List<Book> findByGenreId(String id);

    List<Book> findAll();

    boolean existsById(String id);

    void removeBooksByAuthorId(String id);

    void removeBooksByGenreId(String id);

}
