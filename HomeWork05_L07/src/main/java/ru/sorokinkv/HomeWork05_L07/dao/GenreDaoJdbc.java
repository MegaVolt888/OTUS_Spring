package ru.sorokinkv.HomeWork05_L07.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.sorokinkv.HomeWork05_L07.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class GenreDaoJdbc implements GenreDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.queryForObject("select count(*) from genre",
                new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>(2);
        params.put("id", genre.getId());
        params.put("name", genre.getGenreName());
        namedParameterJdbcOperations.update(
                "insert into genre (id,`name`) values(:id,:name)", params);
    }

    @Override
    public Genre getByName(String genreName) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("name", genreName);
        return namedParameterJdbcOperations.queryForObject("select * from genre where name = :name",
                params, new GenreMapper());
    }

    @Override
    public Genre getById(String uuid) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", uuid);
        return namedParameterJdbcOperations.queryForObject("select * from genre where id = :id",
                params, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return namedParameterJdbcOperations.query("select * from genre", new GenreMapper());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            Genre genre = new Genre(name);
            genre.setId(id);
            return genre; //`title`,`author`, `genre
        }
    }
}
