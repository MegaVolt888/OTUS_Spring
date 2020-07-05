package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class AuthorRepositoryJpaImpl implements AuthorRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

//    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
//
//    public AuthorRepositoryJpaImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
//        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
//    }

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(a) from Author a", Long.class);
        return query.getSingleResult();
    }

    @Override
    public void save(Author author) {
        if (author.getId() <= 0) {
            em.persist(author);
        } else {
            em.merge(author);
        }
    }

    @Override
    public void updateName(Author author) {
        em.merge(author);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete from Author a where a.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Author findById(long id) {
        return Optional.ofNullable(em.find(Author.class, id)).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Override
    public Author findByName(String name) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.name = :name", Author.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        return query.getResultList();
    }
}
