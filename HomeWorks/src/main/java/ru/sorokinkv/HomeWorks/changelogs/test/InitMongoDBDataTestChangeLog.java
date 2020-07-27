package ru.sorokinkv.HomeWorks.changelogs.test;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

@ChangeLog(order = "001")
public class InitMongoDBDataTestChangeLog {
    private Author testAuthor;
    private Genre testGenre;
    private Book testBook;

    @ChangeSet(order = "000", id = "dropDB", author = "sorokinkv", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "initAuthors", author = "sorokinkv", runAlways = true)
    public void initAuthors(MongoTemplate template) {
        testAuthor = template.save(new Author("Sir Arthur Conan Doyle"));
    }

    @ChangeSet(order = "002", id = "initGenres", author = "sorokinkv", runAlways = true)
    public void initGenres(MongoTemplate template) {
        testGenre = template.save(new Genre("detective"));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "sorokinkv", runAlways = true)
    public void initBooks(MongoTemplate template) {
        testBook = template.save(new Book("Favorite Sherlock Holmes Detective Stories", testAuthor, testGenre));
    }
}
