package com.example.moviesapp.view;

import com.example.moviesapp.model.Movie;
import java.util.List;

public interface MovieView {
    void showMovies(List<Movie> movies);
    void showError(String message);
    void showLoading();
    void hideLoading();
    void showJson(String json); // Añade este método
}
