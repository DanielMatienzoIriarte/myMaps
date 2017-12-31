package com.example.danmat.mymaps.pojo;

public class PlaceOfInterest {
    private int avatar;

    private String name;

    private double longitude;

    private double latitude;

    public PlaceOfInterest(int avatar, String name, double latitude, double longitude){
        this.avatar = avatar;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
