package com.example.dhillon.moviesearch;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;

import simplifii.framework.utility.Preferences;


/**
 * Created by raghu on 18/9/16.
 */
public class AppController extends Application {
    private static AppController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.initSharedPreferences(this);
    }

    public static AppController getInstance() {
        return instance;
    }


}
