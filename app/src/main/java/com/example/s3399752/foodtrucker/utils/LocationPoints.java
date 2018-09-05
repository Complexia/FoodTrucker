package com.example.s3399752.foodtrucker.utils;

public class LocationPoints {



    private String date;
    private String time;
    private String location;
    private String stoppingTime;

    public LocationPoints(String date,String time,String location,String stoppingTime){
        this.date=date;
        this.time=time;
        this.location=location;
        this.stoppingTime=stoppingTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStoppingTime() {
        return stoppingTime;
    }

    public void setStoppingTime(String stoppingTime) {
        this.stoppingTime = stoppingTime;
    }
}
