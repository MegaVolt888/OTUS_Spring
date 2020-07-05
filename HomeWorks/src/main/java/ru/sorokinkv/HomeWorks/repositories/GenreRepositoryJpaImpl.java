package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class GenreRepositoryJpaImpl implements GenreRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(g) from Genre g", Long.class);
        return query.getSingleResult();
    }

    @Override
    public void save(Genre genre) {
        if (genre.getId() <= 0) {
            em.persist(genre);
        } else {
            em.merge(genre);
        }
    }

    @Override
    public void updateNameById(Genre genre) {
        em.merge(genre);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete from Genre g where g.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Genre findById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id)).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Override
    public Genre findByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g where g.name = :name", Genre.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }
}
