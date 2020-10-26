package ru.sorokinkv.HomeWorks.models.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sorokinkv.HomeWorks.models.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorViewModel {
    Long id;
    String name;
    List<BookViewModel> books;

    public static AuthorViewModel toViewModel(Author author){
        return AuthorViewModel.builder()
                .id(author.getId())
                .name(author.getName())
                .books(author.getBook().stream().filter(book -> book!=null)
                        .map(b -> new BookViewModel(b.getId(), b.getTitle(), null, b.getGenre()))
                        .collect(Collectors.toList()))
                .build();
    }

}
