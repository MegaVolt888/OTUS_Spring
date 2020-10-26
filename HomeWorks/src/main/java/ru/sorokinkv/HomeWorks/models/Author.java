package ru.sorokinkv.HomeWorks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "author")
public class Author {

    @Id
    private String id;

    private String name;

    public Author(String name) {
        this.name = name;
    }
}
