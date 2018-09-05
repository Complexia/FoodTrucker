package com.example.s3399752.foodtrucker.utils;

import java.util.ArrayList;

public class Factory {

    public static ArrayList<MeetUps> meetUps = new ArrayList<>();
    public static ArrayList<Truck> trackingTrucks;

    public static void setTrackingTrucks(ArrayList<Truck> trackingTrucks1){
        trackingTrucks = trackingTrucks1;
    }
}
