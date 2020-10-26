package ru.sorokinkv.HomeWorks.events.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoBookCascadeSaveAuthorEventsListener extends AbstractMongoEventListener<Author> {

    private final BookRepository bookRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Author> event) {
        super.onBeforeConvert(event);
        Author author = event.getSource();
        String id = String.valueOf(author.getId());
        List<Book> books = bookRepository.findByAuthorId(id);
        books.forEach(book -> {
            book.setAuthor(author);
            bookRepository.save(book);
        });
    }
}
