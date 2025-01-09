package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ActorException;
import com.workintech.s19d1.repository.ActorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new ActorException("Actor does not exist with given id " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, Actor actor) {
        Actor actor1 = findById(id);
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}
