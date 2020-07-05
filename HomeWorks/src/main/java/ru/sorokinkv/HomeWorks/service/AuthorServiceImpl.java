package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class AuthorServiceImpl extends AbstractService implements AuthorService {

    @Override
    public void save() {
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = new Author(0, name);
        authorRepository.save(author);
        showMessage(AUTHOR_SAVE);
    }

    @Override
    public void update() {
        Author author = findAuthorbyName();
        String changeFullName = getMessage(ENTER_NEW_AUTHOR_NAME);
        authorRepository.save(new Author(author.getId(), changeFullName));
        showMessage(AUTHOR_UPDATE + " " + changeFullName);
    }


    @Override
    public void delete() {
        Author author = findAuthorbyName();
        authorRepository.deleteById(author.getId());
        showMessage(AUTHOR_DELETED_SUCCESS);
    }

    @Override
    public Author findByName() {
        return findAuthorbyName();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    private Author findAuthorbyName() {
        String fullname = getMessage(ENTER_AUTHOR_NAME);
        Author author = authorRepository.findByName(fullname);
        if (author == null) {
            throw new RuntimeException(AUTHOR_NOT_FOUND);
        }
        return author;
    }
}
