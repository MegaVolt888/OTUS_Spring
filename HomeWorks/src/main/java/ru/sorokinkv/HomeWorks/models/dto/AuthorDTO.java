package ru.sorokinkv.HomeWorks.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

//    @NonNull
//    @NotEmpty
    private long id;

//    @NonNull
//    @NotEmpty
    private String name;

    private List<BookDTO> books;

}
