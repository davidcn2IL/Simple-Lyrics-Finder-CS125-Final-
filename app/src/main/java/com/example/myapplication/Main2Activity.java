package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {

    private boolean artistCond = false;
    private boolean songCond = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Start, Artist, Song
        Button beginSong = findViewById(R.id.beginSong);
        RadioButton artistBtn = findViewById(R.id.searchArtist);
        RadioButton songBtn = findViewById(R.id.searchSong);

        beginSong.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                playSong();

            }
        });

        artistBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                artistCond = true;
                System.out.println("Artist clicked");
            }
        });

        songBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                songCond = true;
                System.out.println("Song clicked");
            }
        });
    }

    private void playSong() {
        System.out.println("Play Song clicked");
    }
}
