package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class GenreServiceImpl extends AbstractService implements GenreService {


    @Override
    public void save() {
        showMessage(GENRE_SAVE_TITLE);
        String name = getMessage(ENTER_GENRE_NAME);
        Genre genre = new Genre(0, name, null);
        genreRepository.save(genre);
        showMessage(GENRE_SAVE);
    }

    @Override
    public void update() {
        showMessage(GENRE_UPDATE);
        Genre genre = findGenreByName();
        String changeName = getMessage(ENTER_NEW_GENRE_NAME);
        genreRepository.save(new Genre(genre.getId(), changeName, null));
        showMessage(GENRE_UPDATED + " " + changeName);
    }


    @Override
    public Genre foundByName() {
        return findGenreByName();
    }

    @Override
    public void delete() {
        Genre genre = findGenreByName();
        genreRepository.delete(genre);
        showMessage(GENRE_DELETED_SUCCESS);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
