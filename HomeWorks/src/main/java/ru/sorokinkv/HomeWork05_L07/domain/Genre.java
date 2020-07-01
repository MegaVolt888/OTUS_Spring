package ru.sorokinkv.HomeWork05_L07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Genre {
    private UUID id = UUID.randomUUID();
    private String genreName;

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return genreName;
    }
}
