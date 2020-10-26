package ru.sorokinkv.HomeWorks.models.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreViewModel {
    Long id;
    String name;
    List<BookViewModel> books;

    public static GenreViewModel toViewModel(Genre genre){
        return GenreViewModel.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(genre.getBook().stream().filter(book -> book!=null)
                        .map(b -> new BookViewModel(b.getId(), b.getTitle(), b.getAuthor(), null))
                        .collect(Collectors.toList()))
                .build();
    }

}
