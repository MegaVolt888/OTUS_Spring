package ru.sorokinkv.HomeWorks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = UUID.randomUUID();

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author = new Author();


    @Fetch(FetchMode.SUBSELECT)
    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre = new Genre();
//
//    public Book(String title, Author author, Genre genre) {
//        this.title = title;
//        this.author = author;
//        this.genre = genre;
//    }
//
//    public Book() {
//    }
//
//    public Book createBook(String title, String authorName, String genreName) {
//        return new Book(title, new Author(authorName), new Genre(genreName));
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "title='" + title + '\'' +
//                ", author=" + author +
//                ", genre=" + genre +
//                '}';
//    }
}
