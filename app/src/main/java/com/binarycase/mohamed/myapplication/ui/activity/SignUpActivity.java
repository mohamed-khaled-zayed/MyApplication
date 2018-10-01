package com.binarycase.mohamed.myapplication.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.data.api.Constants;
import com.binarycase.mohamed.myapplication.databinding.ActivitySignUpBinding;
import com.binarycase.mohamed.myapplication.interfaces.OnAcceptUseAgreementListener;
import com.binarycase.mohamed.myapplication.model.UserData;
import com.binarycase.mohamed.myapplication.ui.dialog.UseAgreementDialog;
import com.binarycase.mohamed.myapplication.utils.AppUtil;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends BaseActivity implements OnAcceptUseAgreementListener {
    private boolean acceptAgreement;
    private ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        binding.agreeShrootImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadShroot();
                setShroot("mohamed");
            }
        });
         binding.agreeShroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setShroot("mohamed");
            }
        });
        AppUtil.setHtmlText(R.string.agree_shroot_html, (TextView) findViewById(R.id.agree_shroot));

    }

    public void next(View view) {

//        final String user_name=AppUtil.getTextContent(binding.signUpName);
//        final String user_phone=AppUtil.getTextContent(binding.signUpNumber);
//        final String user_email=AppUtil.getTextContent(binding.signUpEmail);
//        final String user_password=AppUtil.getTextContent(binding.signUpPassword);
//        if (ValidateUtils.missingInputs(user_name, user_phone, user_email, user_password)) {
//            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
//            return;
//        }
//
//
//        if (!ValidateUtils.validPhone(user_phone)) {
//            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_phone);
//            return;
//        }
//
//        if (!ValidateUtils.validPassword(user_password)) {
//            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_password);
//            return;
//        }
//
//        if (!AppUtil.isInternetAvailable(this)) {
//            AppUtil.showNoInternetDialog(this);
//            return;
//        }
//
//        if (!acceptAgreement){
//            AppUtil.showInfoDialog(this,R.string.error_toast_accept_agreement);
//        }else {
//            startActivity(new Intent(this,CompleteAccountCreatationActivity.class));;
//        }



        service.registerApi(Constants.CONTENT_TYPE,
                new UserData("Mohamed Khaled","966222455666888",
                        "mocgl559@gmail.com","123456","BinaryCaseDev")).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("response",response.body()+"");

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void acceptUseAgreement() {
        acceptAgreement = true;
        binding.agreeShrootImageView.setImageResource(R.drawable.ic_agreement_check);
    }

    private void setShroot(String shroot) {
        new UseAgreementDialog(SignUpActivity.this,SignUpActivity.this, shroot).showDialog();
    }

    public class CompleteRegisteration {
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(),CompleteAccountCreatationActivity.class));
        }
    }
}

//{
//        "user": {
//        "name": "Ameer Elsherif",
//        "phone": "96611133355555",
//        "email": "engmohamed@gmail.com",
//        "sms_code": "1f9fc0",
//        "api_token": "412e35214467147f17f44d9d2f43e7e8bccea8fa",
//        "updated_at": "2018-10-01 08:46:31",
//        "created_at": "2018-10-01 08:46:31",
//        "id": 4,
//        "sms": {
//        "Code": "108",
//        "MessageIs": "لا يوجد ارقام صالحة للارسال"
//        }
//        }
//        }