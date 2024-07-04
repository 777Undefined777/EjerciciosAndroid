package com.example.moviesapi.view;

import com.example.moviesapi.model.Movie;

public interface MovieView {
    void showMovie(Movie movie);
    void showErrorMessage(String message);
}

