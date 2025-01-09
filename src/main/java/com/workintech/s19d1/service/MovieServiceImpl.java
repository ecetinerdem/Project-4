package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import com.workintech.s19d1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return ;
    }

    @Override
    public Movie findById(Long id) {
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie update(Long id, Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {

    }
}
