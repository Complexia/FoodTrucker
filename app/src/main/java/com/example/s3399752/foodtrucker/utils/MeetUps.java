package com.example.s3399752.foodtrucker.utils;

public class MeetUps {

    private String truckName;
    private String date;
    private String time;
    private String location;

    public MeetUps(String truckName, String date, String time, String location) {
        this.truckName = truckName;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
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
}
