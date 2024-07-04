package com.example.moviesapi.view;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.moviesapi.R;
import com.example.moviesapi.model.Movie;
import com.example.moviesapi.network.MovieApiServiceImpl;
import com.example.moviesapi.presenter.MoviePresenter;

public class MovieActivity extends AppCompatActivity implements MovieView {

    private TextView titleTextView;
    private TextView releaseDateTextView;
    private TextView overviewTextView;
    private TextView ratingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_activity);

        titleTextView = findViewById(R.id.titleTextView);
        releaseDateTextView = findViewById(R.id.releaseDateTextView);
        overviewTextView = findViewById(R.id.overviewTextView);
        ratingTextView = findViewById(R.id.ratingTextView);

        MoviePresenter presenter = new MoviePresenter(this, new MovieApiServiceImpl());
        presenter.getMovieDetails();
    }

    @Override
    public void showMovie(Movie movie) {
        titleTextView.setText(movie.getTitle());
        releaseDateTextView.setText(movie.getReleaseDate());
        overviewTextView.setText(movie.getOverview());
        ratingTextView.setText(String.valueOf(movie.getRating()));
    }

    @Override
    public void showErrorMessage(String message) {
        // Implementar la lógica para mostrar mensajes de error
    }
}
