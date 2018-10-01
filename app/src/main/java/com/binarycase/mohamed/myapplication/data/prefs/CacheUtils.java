package com.binarycase.mohamed.myapplication.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import asia.fivejuly.securepreferences.SecurePreferences;

public class CacheUtils {

    private static final String ENCRYPT_KEY = "saudiassociation@742mhfs9$", PREFS_FILE = "saudiassociation_prefs";

    @NonNull
    public static SharedPreferences getSharedPreferences(Context context) {
        return new SecurePreferences.Builder(context)
                .password(ENCRYPT_KEY)
                .filename(PREFS_FILE)
                .build();
    }

    public static String checkUserState(Context context,String key){
        String state = getSharedPreferences(context).getString(key, "false");
        if (state==null){
            return null;
        }
        return state;
    }

    public static void clearCache(Context context) {
        getSharedPreferences(context).edit().clear().apply();
    }


}
