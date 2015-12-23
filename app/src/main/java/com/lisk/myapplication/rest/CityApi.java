package com.lisk.myapplication.rest;

import com.lisk.myapplication.entity.CityData;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
public interface CityApi {

    @GET("/cities")
    void getCity(Callback<CityData> callback);

}
