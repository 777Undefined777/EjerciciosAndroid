package com.example.moviesapi.network;

import com.example.moviesapi.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
