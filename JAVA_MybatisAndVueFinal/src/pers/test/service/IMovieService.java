package pers.test.service;

import pers.test.entity.Movie;

import java.io.IOException;
import java.util.List;

public interface IMovieService {
    List<Movie> findAllMovie() throws IOException;
}
