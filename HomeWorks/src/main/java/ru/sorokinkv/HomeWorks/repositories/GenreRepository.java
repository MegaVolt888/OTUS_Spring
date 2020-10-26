package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByName(String name);

    boolean existsByName(String name);
}
