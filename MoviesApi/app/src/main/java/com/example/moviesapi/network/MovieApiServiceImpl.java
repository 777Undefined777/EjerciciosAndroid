package com.example.moviesapi.network;

import com.example.moviesapi.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiServiceImpl {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "tu_api_key_aqui";

    private MovieApiService apiService;

    public MovieApiServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MovieApiService.class);
    }

    public void getMovieDetails(Callback<Movie> callback) {
        Call<Movie> call = apiService.getMovieDetails(API_KEY, "en-US");
        call.enqueue(callback);
    }
}
