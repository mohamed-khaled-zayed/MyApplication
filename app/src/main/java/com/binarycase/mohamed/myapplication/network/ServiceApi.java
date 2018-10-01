package com.binarycase.mohamed.myapplication.network;




import com.binarycase.mohamed.myapplication.model.UserData;
import com.binarycase.mohamed.myapplication.responses.loginResponse.LoginResponse;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServiceApi {

  @FormUrlEncoded
  @POST("user/login")
  Call<LoginResponse> loginApi(@FieldMap Map<String, String> params);

  @POST("user/register")
  Call<ResponseBody> registerApi(@Header("Content-Type") String type, @Body UserData subcat);

  @POST("user/login")
  Call<LoginResponse> verifyApi(@Header("Authorization") String auth,@Header("Content-Type") String type, @FieldMap Map<String, String> params);

  @POST("user/login")
  Call<LoginResponse> sendSmsApi(@Header("Authorization") String auth,@Header("Content-Type") String type, @FieldMap Map<String, String> params);

  @POST("user/login")
  Call<LoginResponse> passResetApi(@Header("Authorization") String auth,@Header("Content-Type") String type, @FieldMap Map<String, String> params);

  @POST("user/login")
  Call<LoginResponse> resetVerifyApi(@Header("Authorization") String auth,@Header("Content-Type") String type, @FieldMap Map<String, String> params);

}
