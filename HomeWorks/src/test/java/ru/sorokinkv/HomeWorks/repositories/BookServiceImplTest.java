package ru.sorokinkv.HomeWorks.repositories;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Book;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DisplayName("Book test")
class BookServiceImplTest {
    static final long DEFAULT_BOOKS_COUNT = 4L;
    static final long TEST_GENRE_ID = 1L;
    static final String TEST_BOOK_TITLE = "Test book";
    static final long UPDATE_TEST_BOOK = 2L;
    static final String TEST_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final String EXPECTED_TEST_BOOK_TITLE = "Favorite Sherlock Holmes Detective Stories";
    static final String TEST_GENRE_NAME = "detective";
    static final long TEST_BOOK_ID = 3L;
    static final int EXPECTED_NUMBER_OF_BOOKS = 4;
    static final int EXPECTED_QERIES_COUNT = 1;
    long TEST_AUTHOR_ID = 1L;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("ожидаемое количество книг")
    @Test
    void shouldReturnExpectedBookCount() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(DEFAULT_BOOKS_COUNT);
    }

    @DisplayName("добавление книги в БД")
    @Test
    void shouldInsertBook() {
        Book expected = getBook(1);
        bookRepository.save(expected);
        Book actual = bookRepository.findByTitle(TEST_BOOK_TITLE);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменение книги в БД")
    @Test
    void shouldUpdateBook() {
        Book expected = getBook(UPDATE_TEST_BOOK);
        bookRepository.save(expected);
        Book actual = bookRepository.findByTitle(TEST_BOOK_TITLE);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("удаление книги из БД")
    @Test
    void shouldDeleteBook() {
        bookRepository.deleteById(TEST_BOOK_ID);
        assertThat(bookRepository.findById(TEST_BOOK_ID) == null);
    }

    @DisplayName("получение книги из БД по названию")
    @Test
    void shouldGetByTitleBook() {
        Book book = bookRepository.findByTitle(EXPECTED_TEST_BOOK_TITLE);
        assertThat(book.getTitle()).isEqualTo(EXPECTED_TEST_BOOK_TITLE);
    }

    @DisplayName("получение книги из БД по имени автора")
    @Test
    void shouldReturnBookByAuthor() {
        List<Book> books = bookRepository.findByAuthorName(TEST_AUTHOR_NAME);
        for (Book book : books) {
            assertThat(book.getAuthor().getName()).isEqualTo(TEST_AUTHOR_NAME);
        }
    }

    @DisplayName("получение книги из БД по названию жанра")
    @Test
    void shouldReturnBookByGenre() {
        List<Book> books = bookRepository.findByGenreName(TEST_GENRE_NAME);
        for (Book book : books) {
            assertThat(book.getGenre().getName()).isEqualTo(TEST_GENRE_NAME);
        }
    }

    @DisplayName("получение всех книг из БД")
    @Test
    void shoudGetAllBooks() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        val books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> b.getTitle() != null)
                .allMatch(b -> b.getAuthor() != null)
                .allMatch(b -> b.getGenre() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QERIES_COUNT);
    }

    private Book getBook(long id) {
        Author author = authorRepository.findById(TEST_AUTHOR_ID).get();
        Genre genre = genreRepository.findById(TEST_GENRE_ID).get();
        return new Book(id, TEST_BOOK_TITLE, author, genre);
    }

    public Genre getGenre(String name) {
        Genre genre = genreRepository.findByName(name);
        return genre;
    }

    public Author getAuthor(String name) {
        Author author = authorRepository.findByName(name);
        return author;
    }

}