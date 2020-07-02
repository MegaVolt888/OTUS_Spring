package ru.sorokinkv.HomeWorks.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.sorokinkv.HomeWorks.models.Book;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(BookDaoJdbc.class)
@DisplayName("Book test")
class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDao;

    @Test
    @DisplayName("Book count")
    void count() {
        assertThat(bookDao.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("Book insert")
    void insert() {
        Book book = new Book().createBook("Test", "Tester", "testing");
        bookDao.insert(book);
        Book actualBook = bookDao.getByTitle("Test");
        assertThat(actualBook).isEqualToComparingFieldByField(book);

    }

    @Test
    @DisplayName("Book getAll")
    void getAll() {
        Book book = new Book().createBook("Test", "Tester", "testing");
        bookDao.insert(book);
        assertThat(bookDao.count()).isEqualTo(3);
    }

}