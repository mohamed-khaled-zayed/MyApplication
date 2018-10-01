package com.binarycase.mohamed.myapplication.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.binarycase.mohamed.myapplication.MainActivity;
import com.binarycase.mohamed.myapplication.R;
import com.binarycase.mohamed.myapplication.data.prefs.CacheUtils;
import com.binarycase.mohamed.myapplication.data.prefs.api.Urls;
import com.binarycase.mohamed.myapplication.databinding.ActivitySignInBinding;
import com.binarycase.mohamed.myapplication.responses.loginResponse.LoginResponse;
import com.binarycase.mohamed.myapplication.ui.dialog.AppDialog;
import com.binarycase.mohamed.myapplication.utils.AppUtil;
import com.binarycase.mohamed.myapplication.utils.DialogUtils;
import com.binarycase.mohamed.myapplication.utils.ValidateUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends BaseActivity {

    private ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sign_in);

        binding.setDiscover(new DiscoverApp());
        binding.setForgetPassword(new ForgetPassword());
        binding.setRegister(new UserRegister());
        AppUtil.setHtmlText(R.string.forget_password_html, binding.forgetPasswordTextView);
    }

    public void signIn(View view) {


        final String user_phone=AppUtil.getTextContent(binding.signInPhoneNumber);
        final String user_password=AppUtil.getTextContent(binding.passwordInput);
        if (ValidateUtils.missingInputs(user_phone, user_password)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!ValidateUtils.validPhone(user_phone)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_phone);
            return;
        }

        if (!ValidateUtils.validPassword(user_password)) {
            AppUtil.showInfoDialog(this,R.string.error_dialog_invalid_password);
            return;
        }

        if (!AppUtil.isInternetAvailable(this)) {
            AppUtil.showNoInternetDialog(this);
            return;
        }

        AppUtil.showProgressDialog(this);
        Map<String,String> map=new HashMap<>();
        map.put("api_key",Urls.API_KEY);
        map.put("phone","966"+user_phone);
        map.put("password",user_password);
        map.put("device_id","dddd");
        service.loginApi(map).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                AppUtil.dismissProgressDialog();

                if (response.body().getCode()==200){
                    Log.e("SignInActivity",response.body().getData().toString());
                    AppUtil.showSuccessToast(getBaseContext(),"تم تسجيل الدخول بنجاح");
                    CacheUtils.getSharedPreferences(getBaseContext()).edit().putString("isLogin", "true").apply();
                } else if (response.body().getCode()==205){
                    verifyPhone("");
                }else {
                    AppUtil.showErrorToast(getBaseContext(),"برجاء التاكد من رقم الجوال و كلمة المرور");
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("SignInActivity",t.getMessage());
                AppUtil.showErrorToast(getBaseContext(),"برجاء التاكد من رقم الجوال و كلمة المرور");

            }
        });
    }


    private void verifyPhone(final String phone) {
        DialogUtils.showTwoActionButtonsDialog(SignInActivity.this, R.string.verify_code,
                R.string.dialog_ok, new AppDialog.Action1ButtonListener() {
                    @Override
                    public void onAction1ButtonClick(Dialog dialog) {
                        dialog.dismiss();
                        Intent intent=new Intent(SignInActivity.this, CompleteAccountCreatationActivity.class);
                        intent.putExtra("phone",phone);
                        startActivity(intent);
                        finish();
                    }
                }, R.string.dialog_cancel, new AppDialog.Action2ButtonListener() {
                    @Override
                    public void onAction2ButtonClick(Dialog dialog) {
                        finish();
                    }
                }, false);
    }

//    public void signUp(View view) {
//        startActivity(new Intent(this,SignUpActivity.class));
//    }
//
//    public void forgetPassword(View view) {
//        startActivity(new Intent(this,ForgetPasswordActivity.class));
//    }
//
//    public void discoverApp(View view) {
//        startActivity(new Intent(this, MainActivity.class));
//    }

    public class DiscoverApp {
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }
    }

    public class UserRegister {
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(),SignUpActivity.class));
        }
    }

    public class ForgetPassword {
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(),ForgetPasswordActivity.class));
        }
    }
}
