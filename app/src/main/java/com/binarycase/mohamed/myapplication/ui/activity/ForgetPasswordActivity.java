package com.binarycase.mohamed.myapplication.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.databinding.ActivityForgetPasswordBinding;
import com.binarycase.mohamed.myapplication.utils.AppUtil;
import com.binarycase.mohamed.myapplication.utils.ValidateUtils;

public class ForgetPasswordActivity extends AppCompatActivity {

    private ActivityForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_forget_password);
    }

    public void CheckCode(View view) {

        final String user_phone=AppUtil.getTextContent(binding.phoneNumber);

        if (ValidateUtils.missingInputs(user_phone)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!ValidateUtils.validPhone(user_phone)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_phone);
            return;
        }

        if (!AppUtil.isInternetAvailable(this)) {
            AppUtil.showNoInternetDialog(this);
            return;
        }
        startActivity(new Intent(this,CheckCodeActivity.class));
    }
}
