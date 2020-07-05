package ru.sorokinkv.HomeWorks.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;
import ru.sorokinkv.HomeWorks.repositories.AuthorRepository;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;
import ru.sorokinkv.HomeWorks.repositories.GenreRepository;

import static ru.sorokinkv.HomeWorks.service.MessageList.*;

public class AbstractService {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public IOService messageService;

    public String getMessage(String message) {
        messageService.showMessage(message);
        return messageService.getMessage().toLowerCase();
    }

    public void showMessage(String message) {
        messageService.showMessage(message);
    }
}
