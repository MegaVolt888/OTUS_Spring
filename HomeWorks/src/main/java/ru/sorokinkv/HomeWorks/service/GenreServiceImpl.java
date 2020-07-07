package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.GENRE_DELETED_SUCCESS;

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
}
