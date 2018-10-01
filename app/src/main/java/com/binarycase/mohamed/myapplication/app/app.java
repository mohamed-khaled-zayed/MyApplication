package com.binarycase.mohamed.myapplication.app;

import android.app.Application;

import com.binarycase.mohamed.myapplication.network.RetrofitModule;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitModule.intialize(this);
    }
}
