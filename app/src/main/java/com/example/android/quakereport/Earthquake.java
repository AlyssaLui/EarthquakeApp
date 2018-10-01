package com.example.android.quakereport;


public class Earthquake {
    private double magnitude;
    private String city;
    private String date;
    private long time;
    private String mUrl;

    public Earthquake(double mag, String cityName, long timeInMilliseconds, String url){
        magnitude = mag;
        city = cityName;
        time = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getCity(){
        return city;
    }

    public String getDate() {
        return date;
    }

    public long getTime(){
        return time;
    }

    public String getUrl() {
        return mUrl;
    }
}
