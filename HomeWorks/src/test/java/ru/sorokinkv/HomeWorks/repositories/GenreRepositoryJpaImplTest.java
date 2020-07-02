package ru.sorokinkv.HomeWorks.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.sorokinkv.HomeWorks.models.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@DisplayName("Genre tests")
@Import(GenreRepositoryJpaImpl.class)
class GenreRepositoryJpaImplTest {

    @Autowired
    private GenreRepositoryJpaImpl genreDao;

    @DisplayName("Genre count")
    @Test
    void count() {
        assertThat(genreDao.count()).isEqualTo(1);
    }

    @DisplayName("Genre insert")
    @Test
    void insert() {
        Genre genre = new Genre("Test");
        genreDao.save(genre);
        assertThat(genreDao.findByName("Test")).isEqualToComparingFieldByField(genre);
    }

    @DisplayName("Genre getAll")
    @Test
    void getAll() {
        Genre genre = new Genre("Test");
        genreDao.save(genre);
        assertThat(genreDao.findAll().size()).isEqualTo(2);
    }
}