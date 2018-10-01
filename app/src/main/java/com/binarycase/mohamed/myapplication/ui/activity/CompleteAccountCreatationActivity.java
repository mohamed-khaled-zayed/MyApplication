package com.binarycase.mohamed.myapplication.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.databinding.ActivityCompleteAccountCreatationBinding;
import com.binarycase.mohamed.myapplication.utils.AppUtil;
import com.binarycase.mohamed.myapplication.utils.ValidateUtils;

public class CompleteAccountCreatationActivity extends AppCompatActivity {

    private ActivityCompleteAccountCreatationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_complete_account_creatation);
        AppUtil.setHtmlText(R.string.sms_code,binding.smsText);

    }

    public void confirmCreateAccount(View view) {
        final String smsCode=AppUtil.getTextContent(binding.confirmCodeTxt);

        if (ValidateUtils.missingInputs(smsCode)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!AppUtil.isInternetAvailable(this)) {
            AppUtil.showNoInternetDialog(this);
            return;
        }
    }

    public void sendCode(View view) {
    }
}
