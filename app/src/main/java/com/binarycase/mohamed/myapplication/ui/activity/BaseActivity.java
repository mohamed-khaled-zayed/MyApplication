package com.binarycase.mohamed.myapplication.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.network.RetrofitModule;
import com.binarycase.mohamed.myapplication.network.ServiceApi;

public class BaseActivity extends AppCompatActivity {

    public static ServiceApi service= RetrofitModule.getInstance().getService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
