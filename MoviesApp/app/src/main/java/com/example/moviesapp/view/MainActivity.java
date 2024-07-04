package com.example.moviesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviesapp.R;
import com.example.moviesapp.model.Movie;
import com.example.moviesapp.presenter.MoviePresenter;
import com.example.moviesapp.presenter.MoviePresenterImpl;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieView {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView errorTextView;
    private Button viewJsonButton;
    private MovieAdapter adapter;
    private MoviePresenter presenter;
    private String jsonResponse; // Variable para almacenar el JSON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        errorTextView = findViewById(R.id.error_text_view);
        viewJsonButton = findViewById(R.id.view_json_button);

        adapter = new MovieAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        presenter = new MoviePresenterImpl(this);
        presenter.getMovies();

        // Configurar el botón para mostrar el JSON
        viewJsonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jsonResponse != null) {
                    Intent intent = new Intent(MainActivity.this, JsonViewerActivity.class);
                    intent.putExtra("json_data", jsonResponse);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.setMovies(movies);
    }

    @Override
    public void showError(String message) {
        errorTextView.setText(message);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showJson(String json) {
        this.jsonResponse = json; // Guarda el JSON en la variable
    }
}
