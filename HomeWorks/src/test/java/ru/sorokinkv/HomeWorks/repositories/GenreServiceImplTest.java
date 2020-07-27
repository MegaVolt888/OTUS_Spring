package ru.sorokinkv.HomeWorks.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sorokinkv.HomeWorks.models.Genre;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Genre tests")
class GenreServiceImplTest extends AbstractRepositoryTest {
    static final long DEFAULT_GENRES_COUNT = 1L;
    static final String EXPECTED_GENRE_NAME = "test";
    static final long TEST_GENRE_ID = 1L;
    static final long DEFAULT_COUNT_AFTER_DELETE = 1L;
    static final String TEST_GENRE_NAME = "detective";
    static final int EXEPECTED_NUMBER_OF_GENRES = 2;
    static final int EXPECTED_QERIES_COUNT = 1;


    @Autowired
    GenreRepository genreRepository;

    @DisplayName("ожидаемое количество жанров")
    @Test
    void shoudReturnExpectedGenreCount() {
        long count = genreRepository.count();
        assertThat(count).isEqualTo(DEFAULT_GENRES_COUNT);
    }

    @DisplayName("добавление жанра в БД")
    @Test
    void shoudInsertGenre() {
        Genre expected = new Genre(EXPECTED_GENRE_NAME);
        genreRepository.save(expected);
        Genre actual = genreRepository.findById(expected.getId());
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменение жанра в БД")
    @Test
    void shouldUpdateGenre() {
        Genre expected = new Genre(EXPECTED_GENRE_NAME);
        genreRepository.save(expected);
        Genre actual = genreRepository.findByName(EXPECTED_GENRE_NAME);
        assertThat(actual).isEqualToComparingFieldByField(expected);

    }

    @DisplayName("удаление жанра из БД")
    @Test
    void shoudDeleteGenre() {
        genreRepository.deleteById(TEST_GENRE_ID);
        long count = genreRepository.count();
        assertThat(count).isEqualTo(DEFAULT_COUNT_AFTER_DELETE);
    }

    @DisplayName("получение жанра из БД по id")
    @Test
    void shouldGetByIdGenre() {
        String id = genreRepository.findByName(TEST_GENRE_NAME).getId();
        Genre genre = genreRepository.findById(id);
        assertThat(genre.getId()).isEqualTo(id);
    }

    @DisplayName("получение жанра из БД по названию")
    @Test
    void shouldGetByNameGenre() {
        Genre genre = genreRepository.findByName(TEST_GENRE_NAME);
        assertThat(genre.getName()).isEqualTo(TEST_GENRE_NAME);
    }

    @DisplayName("получение всех жанров из БД")
    @Test
    void shoudGetAllGenres() {
        val genres = genreRepository.findAll();
        assertThat(genres).isNotNull().hasSize(2)
                .allMatch(g -> g.getName() != null);
    }

}