package com.sakhi.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {
    private static final String PREF_NAME = "SakhiPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_TYPE = "userType";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPrefsHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserData(String username, String userType) {
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_TYPE, userType);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "Anonymous User");
    }

    public String getUserType() {
        return sharedPreferences.getString(KEY_USER_TYPE, "student");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}