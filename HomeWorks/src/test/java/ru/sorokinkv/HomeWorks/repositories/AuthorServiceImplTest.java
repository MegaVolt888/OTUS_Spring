package ru.sorokinkv.HomeWorks.repositories;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DisplayName("Author repository test")
class AuthorServiceImplTest {
    static final long AUTHORS_COUNT_IN_DB = 2;
    static final int EXEPECTED_AUTHORS = 2;
    static final String EXPECTED_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final long TEST_AUTHOR_ID = 1;
    static final String TEST_AUTHOR_NAME = "Arthur Conan Doyle";
    public static final int EXPECTED_COUNT = 1;

    @Autowired
    private AuthorRepository repository;
    @Autowired

    private TestEntityManager em;

    @DisplayName("ожидаемое количество авторов")
    @Test
    void shouldReturnExpectedAuthorCount() {
        long count = repository.count();
        assertThat(count).isEqualTo(AUTHORS_COUNT_IN_DB);
    }

    @DisplayName("добавление автора в БД")
    @Test
    void shouldToSaveAuthor() {
        Author expected = new Author(0, EXPECTED_AUTHOR_NAME);
        repository.save(expected);
        Author actual = repository.findById(expected.getId());
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменнение автора в БД")
    @Test
    void shouldUpdateAuthor() {
        Author expected = new Author(TEST_AUTHOR_ID, TEST_AUTHOR_NAME);
        repository.save(expected);
        Author actual = repository.findById(TEST_AUTHOR_ID);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("удаление автора из БД")
    @Test
    void shoudDeleteAuthor() {
        repository.deleteById(TEST_AUTHOR_ID);
        assertThat(repository.findById(TEST_AUTHOR_ID) == null);
    }

    @DisplayName("получение автора из БД по id")
    @Test
    void shouldGetByIdAuthor() {
        Author author = repository.findById(TEST_AUTHOR_ID);
        System.out.println(author.getId());
        assertThat(author.getId()).isEqualTo(TEST_AUTHOR_ID);
    }

    @DisplayName("получение автора из БД по имени")
    @Test
    void shouldGetByNameAuthor() {
        Author author = repository.findByName(EXPECTED_AUTHOR_NAME);
        System.out.println(author);
        assertThat(author.getName()).isEqualTo(EXPECTED_AUTHOR_NAME);
    }

    @DisplayName("получение всех авторов из БД")
    @Test
    void shoudGetAllAuthors() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        List<Author> authors = repository.findAll();
        assertThat(authors).isNotNull().hasSize(EXEPECTED_AUTHORS)
                .allMatch(a -> a.getName() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_COUNT);
    }
}