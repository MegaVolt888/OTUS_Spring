package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import ru.sorokinkv.HomeWorks.models.dto.GenreDTO;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;

public interface GenreService {

    Genre createNewGenre(@NonNull GenreDTO genreDTO);

    Genre save(String name);

    Genre update(Genre genre);

    Genre foundByName(String name);

    boolean delete(String name);

    boolean deleteById(long id);

    Genre findById(Long id);

    boolean existsByName(String name);

    boolean existsById(Long id);

    List<Genre> findAll();
}
