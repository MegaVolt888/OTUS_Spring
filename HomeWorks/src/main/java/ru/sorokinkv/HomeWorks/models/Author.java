package ru.sorokinkv.HomeWorks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "author_name", nullable = false, unique = true)
    private String authorName;

//    public Author(String authorName) {
//        this.authorName = authorName;
//    }
//
//    @Override
//    public String toString() {
//        return authorName;
//    }
}
