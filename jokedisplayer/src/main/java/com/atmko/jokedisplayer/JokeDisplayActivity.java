/*
 * Copyright (C) 2019 Aayat Mimiko
 */

package com.atmko.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String DISPLAY_JOKE_KEY = "display joke";
    private static final String DISPLAY_JOKE_ERROR = "no joke found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent receivedIntent = getIntent();

        if (receivedIntent.hasExtra(DISPLAY_JOKE_KEY)) {
            String jokeString = receivedIntent.getStringExtra(DISPLAY_JOKE_KEY);

            TextView jokeTextView = findViewById(R.id.joke_text_view);

            jokeTextView.setText(jokeString);

        } else {
            Toast.makeText(this, DISPLAY_JOKE_ERROR, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
