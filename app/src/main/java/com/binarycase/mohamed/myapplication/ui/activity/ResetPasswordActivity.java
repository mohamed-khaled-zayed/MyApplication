package com.binarycase.mohamed.myapplication.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.databinding.ActivityResetPasswordBinding;
import com.binarycase.mohamed.myapplication.utils.AppUtil;
import com.binarycase.mohamed.myapplication.utils.ValidateUtils;

public class ResetPasswordActivity extends AppCompatActivity {

    private ActivityResetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_reset_password);
    }

    public void goToHomeActivity(View view) {


        final String newPassword= AppUtil.getTextContent(binding.newPassword);
        final String confirmNewPassword=AppUtil.getTextContent(binding.confirmNewPassword);
        if (ValidateUtils.missingInputs(newPassword, confirmNewPassword)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!ValidateUtils.validPassword(newPassword)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_password);
            return;
        }

        if (!newPassword.equals(confirmNewPassword)){
            AppUtil.showInfoDialog(this,R.string.two_password_not_matches);
            return;
        }

        if (!AppUtil.isInternetAvailable(this)) {
            AppUtil.showNoInternetDialog(this);
            return;
        }
    }
}
