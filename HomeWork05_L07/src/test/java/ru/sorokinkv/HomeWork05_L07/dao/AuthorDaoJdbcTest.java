package ru.sorokinkv.HomeWork05_L07.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;
import ru.sorokinkv.HomeWork05_L07.domain.Author;

import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@DisplayName("Author DAO test")
@Import(AuthorDaoJdbc.class)
class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDaoJdbc authorDao;

    @Test
    @DisplayName("Test count")
    void count() {
        assertThat(authorDao.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test insert")
    void insert() {
        Author author = new Author("Test");
        authorDao.insert(author);
        assertThat(authorDao.getByName("Test")).isEqualToComparingFieldByField(author);
    }

    @  Test
    void getAll() {
        Author author = new Author("Test");
        authorDao.insert(author);
        assertThat(authorDao.getAll().size()).isEqualTo(2);
    }
}