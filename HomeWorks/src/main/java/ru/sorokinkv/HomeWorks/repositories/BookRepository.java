package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);

    Book findByTitle(String title);

    List<Book> findAll();

    List<Book> findByAuthorName(String name);

    List<Book> findByGenreName(String name);
}
