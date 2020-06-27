package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieActivity extends AppCompatActivity {
    ImageView imgBackdrop = findViewById(R.id.backdrop);
    TextView tvTitle = findViewById(R.id.title);
    TextView tvOverView = findViewById(R.id.overview);
    TextView tvReleaseDate = findViewById(R.id.release);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);
        String backdrop = getIntent().getExtras().getString("movie-backdrop");
        String title = getIntent().getExtras().getString("movie-title");
        String overView = getIntent().getExtras().getString("movie-overview");
        String releaseDate = getIntent().getExtras().getString("movie-release");


        tvTitle.setText(title);
        tvOverView.setText(overView);
        tvReleaseDate.setText(releaseDate);
        Glide.with(this).load(backdrop).into(imgBackdrop);
    }
}
