package com.example.android.quakereport;


public class Earthquake {
    private String magnitude;
    private String city;
    private String date;
    private long time;

    public Earthquake(String mag, String cityName, long timeInMilliseconds){
        magnitude = mag;
        city = cityName;
        time = timeInMilliseconds;
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

    public long getTime(){
        return time;
    }


}
