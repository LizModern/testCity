package com.lisk.myapplication.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.converter.GsonConverter;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
public class GsonFactory {

    private GsonFactory() { }

    private static Gson gson;

    public static Gson provideGson() {
        // Gson is thread safe - singleton pattern can be applied
        if (gson == null) {
            gson = new GsonBuilder()
                    .create();
        }
        return gson;
    }


    public static GsonConverter provideGsonConverter() {
        return new GsonConverter(GsonFactory.provideGson());
    }
}