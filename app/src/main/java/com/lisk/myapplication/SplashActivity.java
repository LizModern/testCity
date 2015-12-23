package com.lisk.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.lisk.myapplication.utils.Constants;
import com.lisk.myapplication.utils.Preferences_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {

    @Pref  Preferences_ mPrefs;

    @AfterViews
    public void afterViews(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if (mPrefs.SelectedCity().get().isEmpty()) {
                    intent.setClass(getApplicationContext(), MainActivity_.class);
                } else {
                    intent.setClass(getApplicationContext(), TabInfoActivity_.class);
                }
                startActivity(intent);
            }
        }, Constants.DELAY_5_SEC);
    }

}