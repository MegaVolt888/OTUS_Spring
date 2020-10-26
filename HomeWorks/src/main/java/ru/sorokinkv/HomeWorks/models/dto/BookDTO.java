package ru.sorokinkv.HomeWorks.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

//    @NonNull
//    @NotEmpty
    private Long id;

    @NonNull
    @NotEmpty
    private String title;

    @NonNull
    @NotEmpty
    private AuthorDTO author;

    @NonNull
    @NotEmpty
    private GenreDTO genre;

}
