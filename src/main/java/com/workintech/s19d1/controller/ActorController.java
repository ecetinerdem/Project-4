package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

    private  final ActorService actorService;

    @GetMapping
    public List<ActorResponse> findAll(ActorRequest actorRequest) {
        List<Actor> actors = actorService.findAll();
        return Converter.actorResponseConvert(actors);
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable("id") Long id) {
        Actor foundActor = actorService.findById(id);
        return Converter.actorResponseConvert(foundActor);
    }

    @Transactional
    @PostMapping
    public ActorResponse save (@Validated @RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        List<Movie> movies = actorRequest.getMovies();
        for(Movie movie: movies) {
            actor.addMovie(movie);
        }
        Actor savedActor = actorService.save(actor);
        return Converter.actorResponseConvert(savedActor);
    }

    @Transactional
    @PutMapping("/{id}")
    public ActorResponse update(@PathVariable("id") Long id, @Validated @RequestBody ActorRequest actorRequest) {
        Actor foundActor = actorService.findById(id);
        Actor toBeChanged = actorRequest.getActor();
        toBeChanged.setMovies(foundActor.getMovies());
        toBeChanged.setId(id);
        actorService.save(toBeChanged);
        return Converter.actorResponseConvert(toBeChanged);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return Converter.actorResponseConvert(actor);
    }
}
