package ru.sorokinkv.HomeWorks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@NamedEntityGraph(name = "book-entity-graph", attributeNodes = {
        @NamedAttributeNode("author"),
        @NamedAttributeNode("genre")
})
public class Book {

    @Id
    @SequenceGenerator(name = "book_id", sequenceName = "book_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
