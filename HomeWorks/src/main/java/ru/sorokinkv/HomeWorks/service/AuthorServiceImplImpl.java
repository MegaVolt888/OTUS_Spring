package ru.sorokinkv.HomeWorks.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sorokinkv.HomeWorks.models.dto.AuthorDTO;
import ru.sorokinkv.HomeWorks.models.entity.Author;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImplImpl extends AbstractServiceImpl implements AuthorService {

    @Override
    public Author createNewAuthor(@NonNull AuthorDTO authorDTO){
        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return author;
    }

    @Override
    public Author save(String name) {
        return authorRepository.save(new Author(0 ,name,null));
    }

    @Override
    public Author update(Author authorDiff) {
        if(existsById(authorDiff.getId())) {
            Author author = findById(authorDiff.getId());
            author.setName(authorDiff.getName());
            return authorRepository.save(author);
        } else return null;
    }


    @Override
    public boolean delete(String  name) {
        if (existsByName(name)) {
            Author author = authorRepository.findByName(name);
            authorRepository.deleteById(author.getId());
            return true;
        } else return false;
    }

    @Override
    public boolean deleteById(Long id) {
        Author author = findById(id);
        if(author!=null) {
            authorRepository.deleteById(author.getId());
            return true;
        } else return false;
    }

    @Override
    public boolean existsByName(String name) {
        return authorRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        if (id != null) {
            return authorRepository.existsById(id);
        }
        return false;
    }



    @Transactional
    @Override
    public Author findById(Long id) {
            return authorRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Author findByName(String name) {
        return findAuthorByName(name);
    }

    @Transactional
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

}
