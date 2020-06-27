package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


        String backdrop = Objects.requireNonNull(getIntent().getExtras()).getString("movie-backdrop");
        String title = Objects.requireNonNull(getIntent().getExtras()).getString("movie-title");
        String overView = Objects.requireNonNull(getIntent().getExtras()).getString("movie-overview");
        String releaseDate = Objects.requireNonNull(getIntent().getExtras()).getString("movie-release");



        ImageView imgBackdrop = findViewById(R.id.backdrop);
        TextView tvTitle = findViewById(R.id.title);
        TextView tvOverView = findViewById(R.id.overview);
        TextView tvReleaseDate = findViewById(R.id.release);

        tvTitle.setText(title);
        tvOverView.setText(overView);
        tvReleaseDate.setText(releaseDate);
        Glide.with(this).load(backdrop).into(imgBackdrop);


    }
}
