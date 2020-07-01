package ru.sorokinkv.HomeWorks.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Author {
    private UUID id = UUID.randomUUID();
    private String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return authorName;
    }
}
