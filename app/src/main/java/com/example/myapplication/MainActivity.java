package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.android.volley.ClientError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView test = findViewById(R.id.introText);

        // Request a string response from the provided URL.
        // Instantiate the RequestQueue.

        Button button = (Button) findViewById(R.id.enterApp);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                goToSecondActivity();

            }

        });

    }

    private void goToSecondActivity() {

        Intent intent = new Intent(this, Main2Activity.class);

        startActivity(intent);

    }
}
