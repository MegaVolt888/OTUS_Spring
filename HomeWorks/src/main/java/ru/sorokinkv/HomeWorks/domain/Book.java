package ru.sorokinkv.HomeWorks.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Book {
    private UUID id = UUID.randomUUID();
    private String title = "";
    private Author author = new Author();
    private Genre genre = new Genre();

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book() {
    }

    public Book createBook(String title, String authorName, String genreName){
        return new Book(title, new Author(authorName), new Genre(genreName));
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
