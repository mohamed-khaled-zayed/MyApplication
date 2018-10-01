package com.binarycase.mohamed.myapplication.responses.loginResponse;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("settings")
	private Object settings;

	@SerializedName("device_id")
	private String deviceId;

	@SerializedName("gender")
	private String gender;

	@SerializedName("city")
	private City city;

	@SerializedName("sms_code")
	private String smsCode;

	@SerializedName("verified")
	private String verified;

	@SerializedName("photo")
	private String photo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("token")
	private String token;

	@SerializedName("reset_code")
	private Object resetCode;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("role_id")
	private String roleId;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("city_id")
	private String cityId;

	public void setSettings(Object settings){
		this.settings = settings;
	}

	public Object getSettings(){
		return settings;
	}

	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setSmsCode(String smsCode){
		this.smsCode = smsCode;
	}

	public String getSmsCode(){
		return smsCode;
	}

	public void setVerified(String verified){
		this.verified = verified;
	}

	public String getVerified(){
		return verified;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setResetCode(Object resetCode){
		this.resetCode = resetCode;
	}

	public Object getResetCode(){
		return resetCode;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRoleId(String roleId){
		this.roleId = roleId;
	}

	public String getRoleId(){
		return roleId;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setCityId(String cityId){
		this.cityId = cityId;
	}

	public String getCityId(){
		return cityId;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"settings = '" + settings + '\'' + 
			",device_id = '" + deviceId + '\'' + 
			",gender = '" + gender + '\'' + 
			",city = '" + city + '\'' + 
			",sms_code = '" + smsCode + '\'' + 
			",verified = '" + verified + '\'' + 
			",photo = '" + photo + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",token = '" + token + '\'' + 
			",reset_code = '" + resetCode + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",role_id = '" + roleId + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",city_id = '" + cityId + '\'' + 
			"}";
		}
}