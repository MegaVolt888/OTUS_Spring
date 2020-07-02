package ru.sorokinkv.HomeWorks.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private static NamedParameterJdbcOperations namedParameterJdbcOperations;
    private AuthorDao authorDao;
    private GenreDao genreDao;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        authorDao = new AuthorDaoJdbc(namedParameterJdbcOperations);
        genreDao = new GenreDaoJdbc(namedParameterJdbcOperations);
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.queryForObject("select count(*) from book",
                new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> params = new ConcurrentHashMap<>(4);
        params.put("id", book.getId());
        params.put("title", book.getTitle());
        params.put("author", book.getAuthor().getId());
        params.put("genre", book.getGenre().getId());
        authorDao.insert(book.getAuthor());
        genreDao.insert(book.getGenre());
        namedParameterJdbcOperations.update(
                "insert into book (id,`title`,`author`,`genre`) values(:id,:title,:author, :genre )", params);

    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("select * from book", new BookMapper());
    }

    @Override
    public Book getByTitle(String title) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("title", title);
        return namedParameterJdbcOperations.queryForObject("select * from book where title = :title",
                params, new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book> {

        private AuthorDao authorDao = new AuthorDaoJdbc(namedParameterJdbcOperations);
        private GenreDao genreDao = new GenreDaoJdbc(namedParameterJdbcOperations);

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            Author author = authorDao.getById(resultSet.getString("author"));
            Genre genre = genreDao.getById(resultSet.getString("genre"));
            Book book = new Book(title, author, genre);
            book.setId(id);
            return book;
        }
    }
}
