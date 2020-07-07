package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long id);

    Author findByName(String fullname);
}
