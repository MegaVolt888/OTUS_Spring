package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import javax.persistence.*;
import java.util.List;

@Transactional
@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa {
    @PersistenceContext
    private EntityManager em;


    @Override
    public int count() {
        Query query = em.createQuery("select count(b) " +
                "from Book b ");
        return query.getSingleResult() != null ? Integer.parseInt(query.getSingleResult().toString()) : 0;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() != null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public List<Book> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("book-entity-graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b ", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

    @Override
    public Book findByTitle(String title) {
        TypedQuery<Book> query = em.createQuery("select b " +
                        "from Book b " +
                        "where b.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }
}
