package com.lisk.myapplication.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
public class City {

    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("ImageLink")
    private String imageLink;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageLink() {
        return imageLink;
    }
}
