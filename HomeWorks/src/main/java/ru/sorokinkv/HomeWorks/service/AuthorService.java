package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import ru.sorokinkv.HomeWorks.models.dto.AuthorDTO;
import ru.sorokinkv.HomeWorks.models.entity.Author;

import java.util.List;

public interface AuthorService {

    Author createNewAuthor(@NonNull AuthorDTO authorDTO);

    Author save(String name);

    Author update(Author author);

    Author findById(Long id);

    boolean delete(String name);

    boolean deleteById(Long id);

    boolean existsByName(String name);

    boolean existsById(Long id);

    Author findByName(String name);

    List<Author> findAll();
}
