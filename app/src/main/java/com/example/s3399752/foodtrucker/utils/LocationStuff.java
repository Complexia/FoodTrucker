package com.example.s3399752.foodtrucker.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocationStuff {
    private Context mContext;
    private FoodStuff foodStuff;
    public LocationStuff(Context mContext){
        this.mContext = mContext;
    }


    public void loadFile(){
        foodStuff = new FoodStuff(mContext);
        try{
            foodStuff.loadFile();
            InputStream is = mContext.getAssets().open("tracking.data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            while((line = reader.readLine()) != null){
                line.replaceAll("\\s","");
                String[] splitLine = line.split(",");
                String date = splitLine[0].substring(0,9);
                String time = splitLine[0].substring(10,16);
                String truckID = splitLine[1];
                String stoppingTime = splitLine[2];
                String location = splitLine[3].concat(" " + splitLine[4]);

                for(int i=0;i<foodStuff.getTrucks().size();i++){
                    if(foodStuff.getTrucks().get(i).getTruckID().equals(truckID)){
                        foodStuff.getTrucks().get(i).setDateLocation(date);
                        foodStuff.getTrucks().get(i).setTimeLocation(date);
                        foodStuff.getTrucks().get(i).setStoppingTime(Integer.parseInt(stoppingTime));
                        foodStuff.getTrucks().get(i).setLocationCos(location);
                    }
                }
            }
        }
        catch(Exception e){

        }





    }

    public FoodStuff getFoodStuff() {
        return foodStuff;
    }
}
