package com.example.android.quakereport;


public class Earthquake {
    private String magnitude;
    private String city;
    private String date;

    public Earthquake(String mag, String cityName, String occuranceDate){
        magnitude = mag;
        city = cityName;
        date = occuranceDate;
    }

    public String getMagnitude(){
        return magnitude;
    }

    public String getCity(){
        return city;
    }

    public String getDate() {
        return date;
    }



}
