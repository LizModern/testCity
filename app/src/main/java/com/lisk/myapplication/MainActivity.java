package com.lisk.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.lisk.myapplication.entity.City;
import com.lisk.myapplication.entity.CityData;
import com.lisk.myapplication.rest.CityApi;
import com.lisk.myapplication.ui.CityAdapter;
import com.lisk.myapplication.utils.GsonFactory;
import com.lisk.myapplication.utils.Preferences;
import com.lisk.myapplication.utils.Preferences_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    private static final String API_URL = "http://atw-api.azurewebsites.net/api/";
    private ProgressDialog progress;
    @Pref  Preferences_ mPrefs;

    @AfterViews
    public void afterViews(){

    }

    @Click(R.id.btnLoad)
    public void clickLoad(){
        progress = ProgressDialog.show(this, getResources().getString(R.string.info_loading),
                getResources().getString(R.string.please_wait), true);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        CityApi methods = restAdapter.create(CityApi.class);
        Callback<CityData> callback = new Callback<CityData>() {
            @Override
            public void success(CityData cityData, Response response) {
                progress.dismiss();
                if (cityData.getError() != null && !cityData.getError().isEmpty()) {
                    showAlert(cityData.getError());
                } else {
                    String json = GsonFactory.provideGson().toJson(cityData);
                    mPrefs.SelectedCity().put(json);
                    startTabctivity();
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                progress.dismiss();
                showAlert(retrofitError.getMessage());
            }
        };
        methods.getCity(callback);
    }

    private void startTabctivity(){
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), TabInfoActivity_.class);
        startActivity(intent);
    }

    private void showAlert(String errorMessage){
        new AlertDialog.Builder(getApplicationContext())
                .setTitle(getResources().getString(R.string.error))
                .setMessage(errorMessage)
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
