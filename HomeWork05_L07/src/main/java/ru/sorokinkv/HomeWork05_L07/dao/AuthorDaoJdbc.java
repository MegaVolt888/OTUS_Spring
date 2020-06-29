package ru.sorokinkv.HomeWork05_L07.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.sorokinkv.HomeWork05_L07.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class AuthorDaoJdbc implements AuthorDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.queryForObject("select count(*) from author",
                new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Author author) {
        final HashMap<String, Object> params = new HashMap<>(2);
        params.put("id", author.getId());
        params.put("name", author.getAuthorName());
        namedParameterJdbcOperations.update(
                "insert into author (id,`name`) values(:id,:name)", params);
    }

    @Override
    public Author getByName(String authorName) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", authorName);
        return namedParameterJdbcOperations.queryForObject("select * from author where name = :name",
                params, new AuthorMapper());
    }

    @Override
    public Author getById(String id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select * from author where id = :id",
                params, new AuthorMapper());
    }

    @Override
    public List<Author> getAll() {
        return namedParameterJdbcOperations.query("select * from author", new AuthorMapper());
    }


    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            Author author = new Author(name);
            author.setId(id);
            return author;
        }
    }
}
