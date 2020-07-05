package ru.sorokinkv.HomeWorks.repositories;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@DisplayName("Author repository test")
@Import(AuthorRepositoryJpaImpl.class)
class AuthorRepositoryJpaImplTest {
    static final long AUTHORS_COUNT_IN_DB = 1;
    static final int EXEPECTED_AUTHORS = 1;
    static final String EXPECTED_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final long TEST_AUTHOR_ID = 1;
    static final String TEST_AUTHOR_NAME = "Arthur Conan Doyle";
    public static final int EXPECTED_COUNT = 1;

    @Autowired
    private AuthorRepositoryJpaImpl repositoryJpa;

    @Autowired
    private TestEntityManager em;

    @DisplayName("ожидаемое количество авторов")
    @Test
    void shouldReturnExpectedAuthorCount() {
        long count = repositoryJpa.count();
        assertThat(count).isEqualTo(AUTHORS_COUNT_IN_DB);
    }

    @DisplayName("добавление автора в БД")
    @Test
    void shouldToSaveAuthor() {
        Author expected = new Author(0, EXPECTED_AUTHOR_NAME);
        repositoryJpa.save(expected);
        Author actual = repositoryJpa.findById(expected.getId());
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменнение автора в БД")
    @Test
    void shouldUpdateAuthor() {
        Author expected = new Author(TEST_AUTHOR_ID, TEST_AUTHOR_NAME);
        repositoryJpa.save(expected);
        Author actual = repositoryJpa.findById(TEST_AUTHOR_ID);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("удаление автора из БД")
    @Test
    void shoudDeleteAuthor() {
        repositoryJpa.deleteById(TEST_AUTHOR_ID);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            repositoryJpa.findById(TEST_AUTHOR_ID);
        });
        assertNotNull(thrown.getMessage());
    }

    @DisplayName("получение автора из БД по id")
    @Test
    void shouldGetByIdAuthor() {
        Author author = repositoryJpa.findById(TEST_AUTHOR_ID);
        System.out.println(author.getId());
        assertThat(author.getId()).isEqualTo(TEST_AUTHOR_ID);
    }

    @DisplayName("получение автора из БД по имени")
    @Test
    void shouldGetByNameAuthor() {
        Author author = repositoryJpa.findByName(EXPECTED_AUTHOR_NAME);
        System.out.println(author);
        assertThat(author.getName()).isEqualTo(EXPECTED_AUTHOR_NAME);
    }

    @DisplayName("получение всех авторов из БД")
    @Test
    void shoudGetAllAuthors() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        List<Author> authors = repositoryJpa.findAll();
        assertThat(authors).isNotNull().hasSize(EXEPECTED_AUTHORS)
                .allMatch(a -> a.getName() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_COUNT);
    }
}