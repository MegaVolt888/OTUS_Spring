package ru.sorokinkv.HomeWorks.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.sorokinkv.HomeWorks.models.Author;
import ru.sorokinkv.HomeWorks.models.Book;
import ru.sorokinkv.HomeWorks.models.Genre;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {
    private Author sirArthurConanDoyle;
    private Author stanislavLem;

    private Genre detective;
    private Genre fantastic;

    private Book sherlockHolmes;
    private Book baskervilles;
    private Book theFuturologicalCongress;
    private Book onPatrol;


    @ChangeSet(order = "000", id = "dropDB", author = "sorokinkv", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "initAuthors", author = "sorokinkv", runAlways = true)
    public void initAuthors(MongoTemplate template) {
        sirArthurConanDoyle = template.save(new Author("Sir Arthur Conan Doyle"));
        stanislavLem = template.save(new Author("Stanislav Lem"));
    }

    @ChangeSet(order = "002", id = "initGenres", author = "sorokinkv", runAlways = true)
    public void initGenres(MongoTemplate template) {
        detective = template.save(new Genre("detective"));
        fantastic = template.save(new Genre("fantastic"));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "sorokinkv", runAlways = true)
    public void initBooks(MongoTemplate template) {
        sherlockHolmes = template.save(new Book("Favorite Sherlock Holmes Detective Stories", sirArthurConanDoyle, detective));
        baskervilles = template.save(new Book("The Hound of the Baskervilles", sirArthurConanDoyle, detective));

        theFuturologicalCongress = template.save(new Book("THE FUTUROLOGICAL CONGRESS", stanislavLem, fantastic));
        onPatrol = template.save(new Book("On Patrol", stanislavLem, fantastic));
    }
}
