/*
 * Copyright (C) 2019 Aayat Mimiko
 */

package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//NOTE tests are base on data passed into activity through intents. Changing this data may cause tests to fail
//Note: for phone testing
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void Test_EndPointsAsyncTask() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.StartJokeDisplayListener() {
            @Override
            public void startJokeActivity(String jokeString) {
                Assert.assertTrue(!jokeString.equals(""));
                Assert.assertNotNull(jokeString);
            }
        });
        endpointsAsyncTask.execute();
    }
}
