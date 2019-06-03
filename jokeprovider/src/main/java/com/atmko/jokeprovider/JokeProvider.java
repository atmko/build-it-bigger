/*
 * Copyright (C) 2019 Aayat Mimiko
 */

package com.atmko.jokeprovider;

import java.util.ArrayList;

public class JokeProvider {
    private String joke;

    public JokeProvider() {
        setJoke();
    }

    private void setJoke() {
        ArrayList<String> jokeList = new ArrayList<>();

        jokeList.add("why did the chicken cross the road?\n" +
                "to get to the other side");

        jokeList.add("Why is 6 afraid of 7?\n" +
                "because 7 8 9");

        jokeList.add("There are two muffins baking in the oven. One muffin says to the other,\n" +
                "\"Phew, is it getting hot in here or is it just me?\"\n" +
                "" +
                "The other muffin says, \"AAAAHHH!! A TALKING MUFFIN!\"");

        jokeList.add("Why shouldn't you write with a broken pencil?\n" +
                "Because it's pointless.");

        jokeList.add("Why do seagulls fly over the sea?\n" +
                "Because if they flew over a bay, they would be bagels.");

        int minIndexValue = 0;
        int maxIndexValue = jokeList.size() - 1;

        //highest possible value that can be added to minimum value to become maximum
        //i.e minIndexValue + normalizer = maxIndexValue
        int normalizer = maxIndexValue - minIndexValue;

        //randomRatio highest possible value is 1
        double randomRatio = Math.random();

        //where (randomRatio * normalizer) <= normalizer...
        //because randomRatio caps at 1
        Double indexDouble = minIndexValue + (randomRatio * normalizer);

        //round to whole number
        Long roundedIndexLong = Math.round(indexDouble);

        //convert to integer
        int index = roundedIndexLong.intValue();

        this.joke = jokeList.get(index);
    }

    public String getJoke() {
        return this.joke;
    }
}
