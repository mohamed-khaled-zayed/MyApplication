package com.binarycase.mohamed.myapplication.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.databinding.ActivityCheckCodeBinding;
import com.binarycase.mohamed.myapplication.utils.AppUtil;
import com.binarycase.mohamed.myapplication.utils.ValidateUtils;

import java.util.HashMap;
import java.util.Map;

public class CheckCodeActivity extends AppCompatActivity {

    private ActivityCheckCodeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_check_code);
    }

    public void next(View view) {

        final String smsCode=AppUtil.getTextContent(binding.checkCode);

        if (ValidateUtils.missingInputs(smsCode)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!AppUtil.isInternetAvailable(this)) {
            AppUtil.showNoInternetDialog(this);
            return;
        }

        Map<String,String> map=new HashMap<>();
        map.put("name","");
        map.put("phone","");
        map.put("email","");
        map.put("password","");
        map.put("device_id","");

        startActivity(new Intent(this,ResetPasswordActivity.class));
    }
}
