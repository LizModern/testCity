package com.lisk.myapplication.utils;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;


/**
 * Created by e.kazimirova on 23.12.2015.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface Preferences {

    @DefaultString("")
    String SelectedCity();

}
