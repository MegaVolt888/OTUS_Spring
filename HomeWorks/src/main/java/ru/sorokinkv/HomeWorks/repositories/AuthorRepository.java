package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, Long> {
    long count();

    Author save(Author author);

    void deleteById(String id);

    Author findById(String id);

    Author findByName(String name);

    List<Author> findAll();

    Author findByIdIsNull(String id);
}
