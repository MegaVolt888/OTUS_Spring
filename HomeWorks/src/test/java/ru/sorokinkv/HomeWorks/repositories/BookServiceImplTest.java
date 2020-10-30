package ru.sorokinkv.HomeWorks.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Book test")
class BookServiceImplTest extends AbstractRepositoryTest {
    static final long DEFAULT_BOOKS_COUNT = 1L;
    static final String TEST_BOOK_TITLE = "Test book";
    static final String TEST_AUTHOR_NAME = "Sir Arthur Conan Doyle";
    static final String EXPECTED_TEST_BOOK_TITLE = "Favorite Sherlock Holmes Detective Stories";
    static final String TEST_GENRE_NAME = "detective";
    static final long TEST_BOOK_ID = 3L;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @DisplayName("ожидаемое количество книг")
    @Test
    void shouldReturnExpectedBookCount() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(DEFAULT_BOOKS_COUNT);
    }

    @DisplayName("добавление книги в БД")
    @DirtiesContext
    @Test
    void shouldInsertBook() {
        Book expected = getTestBook();
        bookRepository.save(expected);
        Book actual = bookRepository.findByTitle(TEST_BOOK_TITLE);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @DisplayName("изменение книги в БД")
    @DirtiesContext
    @Test
    void shouldUpdateBook() {
        Book expected = getTestBook();
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
        List<Book> books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(1)
                .allMatch(b -> b.getTitle() != null);
    }

    private Book getTestBook() {
        Author author = authorRepository.findByName(TEST_AUTHOR_NAME);
        Genre genre = genreRepository.findByName(TEST_GENRE_NAME);
        return new Book(TEST_BOOK_TITLE, author, genre);
    }


}