package ru.sorokinkv.HomeWorks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @SequenceGenerator(name = "author_id", sequenceName = "author_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
