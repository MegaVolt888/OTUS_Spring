package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class GenreRepositoryJpaImpl implements GenreRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(g) from Genre g", Long.class);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void save(Genre genre) {
        if (genre.getId() <= 0) {
            em.persist(genre);
        } else {
            em.merge(genre);
        }
    }

    @Transactional
    @Override
    public void updateNameById(Genre genre) {
        em.merge(genre);
    }

    @Transactional
    @Override
    public void deleteGenre(Genre genre) {
        em.remove(genre);
    }

    @Transactional
    @Override
    public Genre findById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id)).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Transactional
    @Override
    public Genre findByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g where g.name = :name", Genre.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Set<Book> getAllBooks(String name) {
        Genre genre = findByName(name);
        return genre.getBooksCollections();
    }
}
