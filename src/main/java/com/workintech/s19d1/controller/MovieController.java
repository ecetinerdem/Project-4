package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieRequest;
import com.workintech.s19d1.dto.MovieResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> findAll() {
        List<Movie> movies = movieService.findAll();
        return Converter.movieResponseConvert(movies);
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable("id") Long id) {
        Movie foundMovie = movieService.findById(id);
        return Converter.movieResponseConvert(foundMovie);
    }

    @Transactional
    @PostMapping
    public MovieResponse save(@Validated @RequestBody MovieRequest movieRequest) {
        Movie foundMovie = movieRequest.getMovie();
        List<Actor> actors = movieRequest.getActors();

        for(Actor actor: actors) {
            foundMovie.addActor(actor);
        }
        Movie savedMovie = movieService.save(foundMovie);
        return Converter.movieResponseConvert(savedMovie);
    }

    @Transactional
    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable("id") Long id, @Validated @RequestBody MovieRequest movieRequest) {
        Movie foundMovie = movieService.findById(id);
        Movie toBeChanged = movieRequest.getMovie();
        toBeChanged.setActors(foundMovie.getActors());
        toBeChanged.setId(foundMovie.getId());
        movieService.save(toBeChanged);
        return Converter.movieResponseConvert(toBeChanged);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable("id") Long id) {
        Movie toBeDeleted = movieService.findById(id);
        movieService.delete(toBeDeleted);
        return Converter.movieResponseConvert(toBeDeleted);
    }

}
