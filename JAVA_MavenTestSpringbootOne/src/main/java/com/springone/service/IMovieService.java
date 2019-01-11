package com.springone.service;

import com.springone.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAllMovies();
}
