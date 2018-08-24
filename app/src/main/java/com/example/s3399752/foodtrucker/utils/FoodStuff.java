package com.example.s3399752.foodtrucker.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FoodStuff {
    private Context mContext;
    private ArrayList<Truck> trucks = new ArrayList<>();
    private ArrayList<String> alStrings = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private Truck truck;
    public FoodStuff(Context mContext){
        this.mContext = mContext;
    }

    public void loadFile(){
        try{
            InputStream is = mContext.getAssets().open("food_truck_data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            while((line = reader.readLine()) != null){
                String[] splitLine = line.split(",");
                truck = new Truck();
                truck.setTruckName(splitLine[1]);
                for(int i = 2;i<splitLine.length;i++){
                    if(!(splitLine[i].contains("/"))){
                        categories.add(splitLine[i]);
                    }
                    else{
                        truck.setTruckWebsite(splitLine[i]);
                        truck.setTruckClassification(splitLine[i+1]);
                        break;
                    }
                }
                truck.setTruckCategories(categories);
                trucks.add(truck);

            }
        }
        catch(Exception e){

        }

        Log.v("myTag",trucks.get(0).getTruckWebsite());



    }


    public ArrayList<Truck> getTrucks() {
        return trucks;
    }
}
