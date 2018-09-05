package com.example.s3399752.foodtrucker.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    private String truckID;
    private String truckName;
    private ArrayList<String> truckCategories = new ArrayList<>();
    private String truckWebsite;
    private String truckClassification;



    private String dateLocation;
    private String locationCos;


    private String timeLocation;



    private int stoppingTime;

    public Truck(String truckID, String truckName, ArrayList truckCategories, String truckWebsite, String truckClassification) {
        this.truckID = truckID;
        this.truckName = truckName;
        this.truckCategories = truckCategories;
        this.truckWebsite = truckWebsite;
        this.truckClassification = truckClassification;
    }

    public Truck(){

    }

    public String getTruckName() {
        return truckName;
    }

    public ArrayList<String> getTruckCategories() {
        return truckCategories;
    }

    public String getTruckWebsite() {
        return truckWebsite;
    }

    public String getTruckClassification() {
        return truckClassification;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public void setTruckCategories(ArrayList<String> truckCategories) {
        this.truckCategories = truckCategories;
    }

    public void setTruckWebsite(String truckWebsite) {
        this.truckWebsite = truckWebsite;
    }

    public void setTruckClassification(String truckClassification) {
        this.truckClassification = truckClassification;
    }

    public String getTruckID(){
        return truckID;
    }
    public void setTruckID(String truckID){
        this.truckID = truckID;
    }

    public int getStoppingTime() {
        return stoppingTime;
    }

    public void setStoppingTime(int stoppingTime) {
        this.stoppingTime = stoppingTime;
    }

    public String getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(String dateLocation) {
        this.dateLocation = dateLocation;
    }

    public String getTimeLocation() {
        return timeLocation;
    }

    public void setTimeLocation(String timeLocation) {
        this.timeLocation = timeLocation;
    }

    public String getLocationCos() {
        return locationCos;
    }

    public void setLocationCos(String locationCos) {
        this.locationCos = locationCos;
    }


}
