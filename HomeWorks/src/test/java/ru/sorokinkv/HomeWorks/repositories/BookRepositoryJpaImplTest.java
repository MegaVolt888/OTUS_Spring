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
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BookRepositoryJpaImpl.class, AuthorRepositoryJpaImpl.class, GenreRepositoryJpaImpl.class})
@DisplayName("Book test")
class BookRepositoryJpaImplTest {
    static final long DEFAULT_BOOKS_COUNT = 2L;
    static final long TEST_GENRE_ID = 1L;
    static final String TEST_BOOK_TITLE = "Test book";
    static final long UPDATE_TEST_BOOK = 2L;
    static final String TEST_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final String EXPECTED_TEST_BOOK_TITLE = "Favorite Sherlock Holmes Detective Stories";
    static final String TEST_GENRE_NAME = "detective";
    static final long TEST_BOOK_ID = 3L;
    static final long TEST_AUTHOR_ID = 1L;
    static final int EXPECTED_NUMBER_OF_BOOKS = 2;
    static final int EXPECTED_QERIES_COUNT = 1;

    @Autowired
    private BookRepositoryJpaImpl bookRepositoryJpa;

    @Autowired
    private  AuthorRepositoryJpaImpl authorRepositoryJpa;

    @Autowired
    private GenreRepositoryJpaImpl genreRepositoryJpa;

    @Autowired
    private TestEntityManager em;

    @DisplayName("ожидаемое количество книг")
    @Test
    void shouldReturnExpectedBookCount() {
        long count = bookRepositoryJpa.count();

        assertThat(count).isEqualTo(DEFAULT_BOOKS_COUNT);
    }

    @DisplayName("добавление книги в БД")
    @Test
    void shouldInsertBook() {
        Book expected = getBook(1);
        bookRepositoryJpa.save(expected);
        Book actual = bookRepositoryJpa.findByTitle(TEST_BOOK_TITLE);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменение книги в БД")
    @Test
    void shouldUpdateBook() {
        Book expected = getBook(UPDATE_TEST_BOOK);
        bookRepositoryJpa.updateBookById(expected);
        Book actual = bookRepositoryJpa.findByTitle(TEST_BOOK_TITLE);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("удаление книги из БД")
    @Test
    void shouldDeleteBook() {
        bookRepositoryJpa.deleteById(TEST_BOOK_ID);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            bookRepositoryJpa.findById(TEST_BOOK_ID);
        });
        assertNotNull(thrown.getMessage());
    }

    @DisplayName("получение книги из БД по названию")
    @Test
    void shouldGetByTitleBook() {
        Book book = bookRepositoryJpa.findByTitle(EXPECTED_TEST_BOOK_TITLE);
        assertThat(book.getTitle()).isEqualTo(EXPECTED_TEST_BOOK_TITLE);
    }

    @DisplayName("получение книги из БД по имени автора")
    @Test
    void shouldReturnBookByAuthor() {
        Set<Book> books = authorRepositoryJpa.getAllBooks(TEST_AUTHOR_NAME);
        System.out.println(books);
        for(Book book : books) {
            assertThat(book.getAuthor().getName()).isEqualTo(TEST_AUTHOR_NAME);
        }
    }

    @DisplayName("получение книги из БД по названию жанра")
    @Test
    void shouldReturnBookByGenre() {
        Set<Book> books = genreRepositoryJpa.getAllBooks(TEST_GENRE_NAME);
        for(Book book : books) {
            assertThat(book.getGenre().getName()).isEqualTo(TEST_GENRE_NAME);
        }
    }

    @DisplayName("получение всех книг из БД")
    @Test
    void shoudGetAllBooks() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        val books = bookRepositoryJpa.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> b.getTitle() != null)
                .allMatch(b -> b.getAuthor() != null)
                .allMatch(b -> b.getGenre() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QERIES_COUNT);
    }

    private Book getBook(long id) {
        Author author = authorRepositoryJpa.findById(TEST_AUTHOR_ID);
        Genre genre = genreRepositoryJpa.findById(TEST_GENRE_ID);
        return new Book(id, TEST_BOOK_TITLE, author, genre);
    }
}