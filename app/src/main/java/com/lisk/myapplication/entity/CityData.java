package com.lisk.myapplication.entity;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.lisk.myapplication.utils.GsonFactory;
import com.lisk.myapplication.utils.Preferences_;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
public class CityData {

    @SerializedName("Error")
    private String error;

    @SerializedName("Result")
    private City[] result;

    public City[] getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public static CityData loadData(Preferences_ mPrefs) {
        String value = mPrefs.SelectedCity().get();

        if(TextUtils.isEmpty(value)) {
            return null;
        } else {
            return GsonFactory.provideGson().fromJson(value, CityData.class);
        }
    }
}
