package com.portfolio.entity;

import com.google.auto.value.AutoValue.Builder;


@Builder
public class UserEntity {
	
	String name;
	int phone;
	String city;
	public UserEntity(String name, int phone, String city) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", phone=" + phone + ", city=" + city + "]";
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
