package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(b) from Book b  ", Long.class);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void save(Book book) {
        if (book.getId() <= 0) {
            em.persist(book);
        } else {
            em.merge(book);
        }
    }

    @Transactional
    @Override
    public void updateBookById(Book book) {
        em.merge(book);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete from Book b where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public Book findById(long id) {
        return Optional.ofNullable(em.find(Book.class, id)).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Transactional
    @Override
    public Book findByTitle(String title) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "where b.title = :title", Book.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public List<Book> findAll() {
        return em.createQuery("select b from Book b  " //+
                , Book.class)
                .getResultList();
    }
}
