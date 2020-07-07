package ru.sorokinkv.HomeWorks.service;

import org.springframework.stereotype.Service;
import ru.sorokinkv.HomeWorks.models.Author;

import java.util.List;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

@Service
public class AuthorServiceImpl extends AbstractService implements AuthorService {

    @Override
    public void save() {
        showMessage(AUTHOR_SAVE_TITLE);
        String name = getMessage(ENTER_AUTHOR_NAME);
        Author author = new Author(0, name);
        authorRepository.save(author);
        showMessage(AUTHOR_SAVE);
    }

    @Override
    public void update() {
        showMessage(AUTHOR_UPDATE);
        Author author = findAuthorByName();
        String changeFullName = getMessage(ENTER_NEW_AUTHOR_NAME);
        authorRepository.save(new Author(author.getId(), changeFullName));
        showMessage(AUTHOR_UPDATED + " " + changeFullName);
    }


    @Override
    public void delete() {
        showMessage(AUTHOR_DELETE);
        Author author = findAuthorByName();
        authorRepository.deleteById(author.getId());
        showMessage(AUTHOR_DELETED_SUCCESS);
    }

    @Override
    public Author findByName() {
        return findAuthorByName();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
