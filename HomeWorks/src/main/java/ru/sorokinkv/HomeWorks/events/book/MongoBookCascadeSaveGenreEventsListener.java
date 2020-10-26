package ru.sorokinkv.HomeWorks.events.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;
import ru.sorokinkv.HomeWorks.repositories.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoBookCascadeSaveGenreEventsListener extends AbstractMongoEventListener<Genre> {

    private final BookRepository bookRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Genre> event) {
        super.onBeforeConvert(event);
        Genre genre = event.getSource();
        String id = String.valueOf(genre.getId());
        List<Book> books = bookRepository.findByGenreId(id);
        books.forEach(book -> {
            book.setGenre(genre);
            bookRepository.save(book);
        });
    }
}
