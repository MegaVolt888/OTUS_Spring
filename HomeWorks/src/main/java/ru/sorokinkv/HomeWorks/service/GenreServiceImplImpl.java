package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.dto.GenreDTO;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImplImpl extends AbstractServiceImpl implements GenreService {

    @Override
    public Genre createNewGenre(@NonNull GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }

    @Override
    public Genre save(String name) {
        return genreRepository.save(new Genre(0, name, null));
    }

    @Override
    public Genre update(Genre genreDiff) {
        if(existsById(genreDiff.getId())) {
            Genre genre = findById(genreDiff.getId());
           return genreRepository.save(new Genre(genre.getId(), genreDiff.getName(), genre.getBook()));
        } else return null;
    }


    @Transactional
    @Override
    public Genre foundByName(String name) {
        return findGenreByName(name);
    }

    @Override
    public boolean delete(String name) {
        if(existsByName(name)) {
            Genre genre = findGenreByName(name);
            genreRepository.delete(genre);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteById(long id) {
        if(existsById(id)) {
            Genre genre = findById(id);
            genreRepository.delete(genre);
            return true;
        } else return false;
    }

    @Transactional
    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }
    @Override
    public boolean existsByName(String name) {
        return genreRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        if (id != null) {
            return genreRepository.existsById(id);
        }
        return false;
    }

    @Transactional
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
