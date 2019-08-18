package com.example.dogsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SharedPreferencesHelper {

    // Singleton Design Pattern
    private static final String PREF_TIME = "Pref time";
    private static SharedPreferencesHelper instance;
    private SharedPreferences prefs;

    // Constructor
    private SharedPreferencesHelper(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesHelper(context);
        }
        return instance;
    }

    // Caching (Delta)
    public void saveUpdateTime(long time) {
        prefs.edit().putLong(PREF_TIME, time).apply();
    }

    public long getUpdateTime() {
        return prefs.getLong(PREF_TIME, 0);
    }

}
