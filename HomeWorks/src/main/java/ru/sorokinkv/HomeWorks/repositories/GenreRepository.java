package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findById(long id);

    Genre findByName(String name);
}
