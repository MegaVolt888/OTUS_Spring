package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class GenreServiceImpl extends AbstractService implements GenreService {


    @Override
    public Genre foundGenreByName() {
        return findGenreByName();
    }

    @Override
    public void delete() {
        Genre genre = findGenreByName();
        genreRepository.deleteById(genre.getId());
        showMessage(GENRE_DELETED_SUCCESS);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    private Genre findGenreByName() {
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = genreRepository.findByName(name);
        if (genre == null) {
            throw new RuntimeException(GENRE_NOT_FOUND);
        }
        return genre;
    }
}
