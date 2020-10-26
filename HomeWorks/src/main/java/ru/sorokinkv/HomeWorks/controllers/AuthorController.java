package ru.sorokinkv.HomeWorks.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sorokinkv.HomeWorks.models.dto.AuthorDTO;
import ru.sorokinkv.HomeWorks.models.entity.Author;
import ru.sorokinkv.HomeWorks.models.viewmodels.AuthorViewModel;
import ru.sorokinkv.HomeWorks.service.AuthorService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@SuppressWarnings("all")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(value = "/api/authors")
    public List<AuthorViewModel> listAuthors() {
        List<Author> all = authorService.findAll();
        return all.stream().map(AuthorViewModel::toViewModel).collect(Collectors.toList());
    }

    @GetMapping("/api/authors/{id}")
    public ResponseEntity<AuthorViewModel> getAuthorById(@PathVariable(value = "id") Long id) {

            Author author = authorService.findById(id);
            if(author!=null) {
                return ResponseEntity.ok().body(AuthorViewModel.toViewModel(author));
            } else return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/authors")
    public Author createAuthor(@Valid @RequestBody String name) {
        return authorService.save(name);
    }

    @PutMapping("/api/authors")
    public ResponseEntity<AuthorViewModel> updateAuthor(@RequestBody AuthorDTO authorDiff) {
        Author author = authorService.createNewAuthor(authorDiff);
        final Author updatedAuthor = authorService.update(author);
        return ResponseEntity.ok(AuthorViewModel.toViewModel(updatedAuthor));
    }

    @DeleteMapping("/api/authors/{id}")
    public ResponseEntity deleteAuthor(@PathVariable(value = "id") Long id) {
        boolean deleted = authorService.deleteById(id);
        return ResponseEntity.ok(deleted);
    }
}
