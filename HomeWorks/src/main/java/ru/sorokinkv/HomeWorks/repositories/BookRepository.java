package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {

    Book findById(long id);

    Book findByTitle(String title);

    List<Book> findByAuthor(String name);

    List<Book> findByGenre(String name);

    @EntityGraph(attributePaths = {"author", "genre"})
    List<Book> findAll();
}
