package ru.sorokinkv.HomeWorks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.sorokinkv.HomeWorks.dao.AuthorDaoJdbc;
import ru.sorokinkv.HomeWorks.dao.BookDaoJdbc;
import ru.sorokinkv.HomeWorks.dao.GenreDaoJdbc;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final ConsoleService console;
    private final BookDaoJdbc bookDaoJdbc;
    private final AuthorDaoJdbc authorDaoJdbc;
    private final GenreDaoJdbc genreDaoJdbc;



    @ShellMethod(value = "Print all book", key = {"b", "books"})
    public void books() {
        console.write(bookDaoJdbc.getAll().toString());
    }

    @ShellMethod(value = "Print all authors", key = {"a", "authors"})
    public void authors() throws Exception {
        console.write(authorDaoJdbc.getAll().toString());
    }


    @ShellMethod(value = "Print all genres", key = {"g", "genres"})
    public void genres() throws Exception {
        console.write(genreDaoJdbc.getAll().toString());
    }

}
