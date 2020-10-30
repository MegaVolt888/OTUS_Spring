package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    boolean existsByName(String name);
}
