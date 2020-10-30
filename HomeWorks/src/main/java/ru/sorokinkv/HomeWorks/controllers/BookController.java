package ru.sorokinkv.HomeWorks.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sorokinkv.HomeWorks.models.dto.BookDTO;
import ru.sorokinkv.HomeWorks.models.entity.Book;
import ru.sorokinkv.HomeWorks.models.viewmodels.BookViewModel;
import ru.sorokinkv.HomeWorks.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;


    @GetMapping(value = "/api/books")
    public List<BookViewModel> lisBooks() {
        List<Book> books = bookService.findAll();
        return books.stream().map(BookViewModel::toViewModel).collect(Collectors.toList());
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<BookViewModel> getBookById(@PathVariable(value = "id") Long id) {
            Book book = bookService.findById(id);
            if(book!=null) {
               return ResponseEntity.ok().body(BookViewModel.toViewModel(book));
           }else return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/books")
    public ResponseEntity<BookViewModel> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.createNewBook(bookDTO);
        return ResponseEntity.ok().body(BookViewModel.toViewModel(book));
    }

    @PutMapping("/api/books")
    public ResponseEntity<BookViewModel> updateBook(@Valid @RequestBody BookDTO bookDetails) {
        final Book updateBook = bookService.update(bookDetails);
        return ResponseEntity.ok(BookViewModel.toViewModel(updateBook));
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
