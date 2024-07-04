package com.example.moviesapp.presenter;

import com.example.moviesapp.model.Movie;
import com.example.moviesapp.network.MovieApiService;
import com.example.moviesapp.network.MovieResponse;
import com.example.moviesapp.network.RetrofitClient;
import com.example.moviesapp.view.MovieView;
import com.google.gson.Gson;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenterImpl implements MoviePresenter {
    private MovieView view;
    private static final String API_KEY = "358297e61b83f863bda0fbb210c642d0";

    public MoviePresenterImpl(MovieView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        view.showLoading();
        MovieApiService apiService = RetrofitClient.getRetrofitInstance().create(MovieApiService.class);
        Call<MovieResponse> call = apiService.getMovies(API_KEY);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getMovies();
                    view.showMovies(movies);

                    // Convierte la respuesta a JSON
                    String json = new Gson().toJson(response.body());

                    // Pasa el JSON a la vista
                    view.showJson(json);
                } else {
                    view.showError("Failed to fetch movies");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }
}
