/*
 * Copyright (C) 2019 Aayat Mimiko
 */

package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.atmko.jokedisplayer.JokeDisplayActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
        implements EndpointsAsyncTask.StartJokeDisplayListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        final Button tellJokeButton = root.findViewById(R.id.tell_joke_button);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(MainActivityFragment.this).execute();
            }
        });

        return root;
    }

    @Override
    public void startJokeActivity(String jokeString) {
        Intent jokeDisplayIntent = new Intent(getContext(), JokeDisplayActivity.class);
        jokeDisplayIntent.putExtra(JokeDisplayActivity.DISPLAY_JOKE_KEY, jokeString);

        assert getContext() != null;

        getContext().startActivity(jokeDisplayIntent);
    }
}
