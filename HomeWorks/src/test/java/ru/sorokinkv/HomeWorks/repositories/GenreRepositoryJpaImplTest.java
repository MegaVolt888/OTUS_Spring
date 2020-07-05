package ru.sorokinkv.HomeWorks.repositories;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.sorokinkv.HomeWorks.models.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@DisplayName("Genre tests")
@Import(GenreRepositoryJpaImpl.class)
class GenreRepositoryJpaImplTest {
    static final long DEFAULT_GENRES_COUNT = 1L;
    static final String EXPECTED_GENRE_NAME = "test";
    static final long TEST_GENRE_ID = 1L;
    static final long DEFAULT_COUNT_AFTER_DELETE = 0L;
    static final String TEST_GENRE_NAME = "detective";
    static final int EXEPECTED_NUMBER_OF_GENRES = 1;
    static final int EXPECTED_QERIES_COUNT = 1;


    @Autowired
    private GenreRepositoryJpaImpl genreRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("ожидаемое количество жанров")
    @Test
    void shoudReturnExpectedGenreCount() {
        long count = genreRepository.count();
        assertThat(count).isEqualTo(DEFAULT_GENRES_COUNT);
    }

    @DisplayName("добавление жанра в БД")
    @Test
    void shoudInsertGenre() {
        Genre expected = new Genre(1, EXPECTED_GENRE_NAME);
        genreRepository.save(expected);
        Genre actual = genreRepository.findById(expected.getId());
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменение жанра в БД")
    @Test
    void shouldUpdateGenre() {
        genreRepository.deleteById(TEST_GENRE_ID);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            genreRepository.findById(TEST_GENRE_ID);
        });
        assertNotNull(thrown.getMessage());
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
        Genre genre = genreRepository.findById(TEST_GENRE_ID);
        assertThat(genre.getId()).isEqualTo(TEST_GENRE_ID);
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
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        val genres = genreRepository.findAll();
        assertThat(genres).isNotNull().hasSize(EXEPECTED_NUMBER_OF_GENRES)
                .allMatch(g -> g.getName() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QERIES_COUNT);
    }

}