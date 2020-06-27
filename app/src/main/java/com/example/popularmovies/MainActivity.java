package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements DataTransferInterface {
    private static final String TAG = "MainActivity";
    ProgressBar progressBar;
    private ImageView imageView;
    private RequestQueue requestQueue;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ArrayList<ImageUrl> imageUrls;
    String baseUrl = "https://image.tmdb.org/t/p/w500/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_circular_main);
        requestQueue = Volley.newRequestQueue(this);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.PosterList);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        getData();


    }

    private void showView() {

        DataAdapter dataAdapter = new DataAdapter(MainActivity.this, imageUrls,this);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);


    }

    private void getData() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=a458c445ab1d494f168bce78e9ae46bf&language=en-US&page=1";
        imageUrls = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "on Response:" + response);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject data = jsonArray.getJSONObject(i);

                                imageUrls.add(new ImageUrl(baseUrl + data.getString("poster_path"), data.getString("title"), baseUrl + data.getString("backdrop_path"), data.getString("overview"), data.getString("release_date")));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        showView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);
                Log.e(TAG, "onResponse: " + error);

            }
        });
        requestQueue.add(jsonObjectRequest);


    }
    @Override
    public void movieClick(ImageUrl imageUrl, ImageView imageView) {

        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("movie-title", imageUrl.getTitle());
        intent.putExtra("movie-backdrop", imageUrl.getBackPath());
        intent.putExtra("movie-overview", imageUrl.getOverView());
        intent.putExtra("movie-release", imageUrl.getReleaseDate());
        startActivity(intent);

    }

    }

