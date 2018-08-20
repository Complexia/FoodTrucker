package com.example.s3399752.foodtrucker.utils;

import java.util.ArrayList;

public class Truck {

    private String truckName;
    private ArrayList<String> truckCategories = new ArrayList<>();
    private String truckWebsite;
    private String truckClassification;

    public Truck(String truckName, ArrayList truckCategories, String truckWebsite, String truckClassification) {
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
}
