package ru.sorokinkv.HomeWorks.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DisplayName("Author repository test")
@Import(AuthorRepositoryJpaImpl.class)
class AuthorRepositoryJpaImplTest {

    @Autowired
    private AuthorRepositoryJpaImpl repositoryJpa;

    @Test
    @DisplayName("Test count")
    void count() {
        assertThat(repositoryJpa.count()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("Test insert")
//    void insert() {
//        Author author = new Author("Test");
//        authorDao.save(author);
//        assertThat(authorDao.findByName("Test")).isEqualToComparingFieldByField(author);
//    }
//
//    @Test
//    void getAll() {
//        Author author = new Author("Test");
//        authorDao.save(author);
//        assertThat(authorDao.findAll().size()).isEqualTo(2);
//    }
}