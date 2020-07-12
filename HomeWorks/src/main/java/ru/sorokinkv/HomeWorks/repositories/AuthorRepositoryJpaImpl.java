package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class AuthorRepositoryJpaImpl implements AuthorRepositoryJpa {


//    private static BookRepositoryJpaImpl bookRepository = new BookRepositoryJpaImpl();

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(a) from Author a", Long.class);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void save(Author author) {
        if (author.getId() <= 0) {
            em.persist(author);
        } else {
            em.merge(author);
        }
    }

    @Transactional
    @Override
    public void updateName(Author author) {
        em.merge(author);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        em.remove(findById(id));
    }

    @Transactional
    @Override
    public Author findById(long id) {
        return Optional.ofNullable(em.find(Author.class, id)).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Transactional
    @Override
    public Author findByName(String name) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.name = :name", Author.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Set<Book> getAllBooks(String name) {
        Author author = findByName(name);
        return author.getBooks();
    }
}
