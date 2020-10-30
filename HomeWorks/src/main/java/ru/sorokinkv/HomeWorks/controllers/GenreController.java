package ru.sorokinkv.HomeWorks.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sorokinkv.HomeWorks.models.dto.GenreDTO;
import ru.sorokinkv.HomeWorks.models.entity.Genre;
import ru.sorokinkv.HomeWorks.models.viewmodels.GenreViewModel;
import ru.sorokinkv.HomeWorks.service.GenreService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@SuppressWarnings("all")
public class GenreController {

    private final GenreService genreService;

    @GetMapping(value = "/api/genres")
    public List<GenreViewModel> listGenres() {
        List<Genre> all = genreService.findAll();
        return all.stream().map(GenreViewModel::toViewModel).collect(Collectors.toList());
    }

    @GetMapping("/api/genres/{id}")
    public ResponseEntity<GenreViewModel> getAuthorById(@PathVariable(value = "id") Long id) {
        Genre genre = genreService.findById(id);
        if (genre != null) {
            return ResponseEntity.ok().body(GenreViewModel.toViewModel(genre));
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/genres")
    public Genre createGenre(@Valid @RequestBody String genreName) {
        return genreService.save(genreName);
    }

    @PutMapping("/api/genres")
    public ResponseEntity<GenreViewModel> updateGenre(@Valid @RequestBody GenreDTO genreDiff) {
        Genre genre = genreService.createNewGenre(genreDiff);
        final Genre updatedGenre = genreService.update(genre);
        return ResponseEntity.ok(GenreViewModel.toViewModel(updatedGenre));
    }

    @DeleteMapping("/api/genres/{id}")
    public ResponseEntity deleteGenre(@PathVariable(value = "id") Long id) {
        boolean deleted = genreService.deleteById(id);
        return ResponseEntity.ok(deleted);
    }
}
