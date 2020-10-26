package ru.sorokinkv.HomeWorks.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


@DisplayName("Author repository test")
class AuthorServiceImplTest extends AbstractRepositoryTest {
    static final long AUTHORS_COUNT_IN_DB = 1;
    static final String EXPECTED_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final String TEST_AUTHOR_NAME = "Arthur Conan Doyle";

    @Autowired
    private AuthorRepository repository;


    @DisplayName("ожидаемое количество авторов")
    @DirtiesContext
    @Test
    void shouldReturnExpectedAuthorCount() {
        long count = repository.count();
        assertThat(count).isEqualTo(AUTHORS_COUNT_IN_DB);
    }

    @DisplayName("добавление автора в БД")
    @DirtiesContext
    @Test
    void shouldToSaveAuthor() {
        Author expected = new Author(TEST_AUTHOR_NAME);
        repository.save(expected);
        Author actual = repository.findById(expected.getId());
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменнение автора в БД")
    @DirtiesContext
    @Test
    void shouldUpdateAuthor() {
        String idA = getAuthorId(EXPECTED_AUTHOR_NAME);
        Author expected = new Author(idA, TEST_AUTHOR_NAME);
        repository.save(expected);
        String idB = getAuthorId(TEST_AUTHOR_NAME);
        Author actual = repository.findById(idB);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }


    @DisplayName("получение автора из БД по id")
    @DirtiesContext
    @Test
    void shouldGetByIdAuthor() {
        Author author = repository.findById(getAuthorId(EXPECTED_AUTHOR_NAME));
        assertThat(author.getId()).isEqualTo(getAuthorId(EXPECTED_AUTHOR_NAME));
    }

    @DisplayName("удаление автора из БД")
    @DirtiesContext
    @Test
    void shoudDeleteAuthor() {
        Author author = repository.findByName(EXPECTED_AUTHOR_NAME);
        String id = author.getId();
        repository.deleteById(id);
        assertNull(repository.findByIdIsNull(id));
    }


    @DisplayName("получение автора из БД по имени")
    @DirtiesContext
    @Test
    void shouldGetByNameAuthor() {
        Author author = repository.findByName(EXPECTED_AUTHOR_NAME);
        System.out.println(author);
        assertThat(author.getName()).isEqualTo(EXPECTED_AUTHOR_NAME);
    }

    @DisplayName("получение всех авторов из БД")
    @DirtiesContext
    @Test
    void shoudGetAllAuthors() {
        List<Author> authors = repository.findAll();
        System.out.println(authors);
        assertThat(authors).isNotNull().hasSize(1)
                .allMatch(a -> a.getName() != null);
    }

    private String getAuthorId(String name) {
        Author a = repository.findByName(name);
        return a.getId();
    }
}