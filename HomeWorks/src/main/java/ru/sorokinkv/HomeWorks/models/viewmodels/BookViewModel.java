package ru.sorokinkv.HomeWorks.models.viewmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.entity.Book;
import ru.sorokinkv.HomeWorks.models.entity.Genre;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookViewModel {
    Long id;
    String title;
    Author author;
    Genre genre;

    public static BookViewModel toViewModel(Book book){
        return BookViewModel.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .build();
    }
}
