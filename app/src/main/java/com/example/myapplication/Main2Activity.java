package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.ClientError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    private boolean artistCond = false;
    private boolean songCond = false;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Start, Artist, Song
        Button startSearch = findViewById(R.id.startSearch);
        Button clearSearch = findViewById(R.id.clearSearch);


        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                searchSong();

            }
        });

        clearSearch.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                TextView artist = findViewById(R.id.search);
                TextView song = findViewById(R.id.search2);
                TextView lyrics = findViewById(R.id.lyrics);

                artist.setText("");
                song.setText("");
                lyrics.setText("");

            }
        });

    }

    private void searchSong() {
        url = "https://api.lyrics.ovh/v1/";

        TextView artist = findViewById(R.id.search);
        TextView song = findViewById(R.id.search2);

        String artistStr = artist.getText().toString();
        String songStr = song.getText().toString();

        System.out.println("the input was: " + artistStr + " " + songStr);
        url = url + artistStr + "/" + songStr;

        final TextView test = findViewById(R.id.lyrics);
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String holder = response.getString("lyrics");
                            test.setText(holder);
                        } catch (JSONException e){
                            System.out.println("JSON error: " + e);
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        if (error instanceof ClientError) {
                            test.setText("No such song / artist exists!");
                        } else {
                            System.out.println("Other error: " + error);
                        }
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }
}
