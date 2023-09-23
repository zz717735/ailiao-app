package com.chongdong.ailiaoapp.model;

//经纬度类
public class LatitudeAndLongitude {

	private double Longitude;//经度
	private double Latitude;//纬度

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double lng) {
		Longitude = lng;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double lat) {
		Latitude = lat;
	}

	@Override
	public String toString() {
		return "LatitudeAndLongitude [Longitude=" + Longitude + ", Latitude="
				+ Latitude + "]";
	}
}

	
