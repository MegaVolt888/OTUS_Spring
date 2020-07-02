package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Author;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

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
    public int count() {
        Query query = em.createQuery("select count(a) " +
                        "from Author a ");
        return query.getSingleResult() != null ? Integer.parseInt(query.getSingleResult().toString()) : 0;
    }

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public Author findByName(String authorName) {
        TypedQuery<Author> query = em.createQuery("select a " +
                        "from Author a " +
                        "where a.authorName = :authorName",
                Author.class);
        query.setParameter("author_name", authorName);
        return query.getSingleResult();
    }

    @Override
    public Author findById(String id) {
        TypedQuery<Author> query = em.createQuery("select a " +
                        "from Author a " +
                        "where a.id = :id",
                Author.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Author> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author-entity-graph");
        TypedQuery<Author> query = em.createQuery("select a from Author a ", Author.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }
}
