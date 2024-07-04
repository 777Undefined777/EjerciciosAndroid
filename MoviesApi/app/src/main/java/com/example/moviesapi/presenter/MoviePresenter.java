package com.example.moviesapi.presenter;

import com.example.moviesapi.network.MovieApiService;
import com.example.moviesapi.view.MovieView;

public class MoviePresenter {
    private MovieView view;
    private MovieApiService apiService;

    public MoviePresenter(MovieView view, MovieApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    public void getMovieDetails() {
        // Aquí se realizaría la llamada a la API usando Retrofit
        // y se manejaría la respuesta para mostrar los detalles de la película en la vista
    }
}
