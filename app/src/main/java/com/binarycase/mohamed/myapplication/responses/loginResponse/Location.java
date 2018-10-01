package com.binarycase.mohamed.myapplication.responses.loginResponse;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("user_id")
	private String userId;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("longtude")
	private String longtude;

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setLongtude(String longtude){
		this.longtude = longtude;
	}

	public String getLongtude(){
		return longtude;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"user_id = '" + userId + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",longtude = '" + longtude + '\'' + 
			"}";
		}
}