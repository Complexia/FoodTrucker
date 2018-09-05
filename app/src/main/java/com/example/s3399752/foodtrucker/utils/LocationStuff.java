package com.example.s3399752.foodtrucker.utils;

import android.content.Context;
import android.util.Log;

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

                String[] splitLine = line.split(",");
                String date = splitLine[0].substring(0,10).trim();
                String time = splitLine[0].substring(11,18).trim();
                String truckID = splitLine[1].trim();
                String stoppingTime = splitLine[2].trim();
                String location = splitLine[3].concat(" " + splitLine[4]).trim();




                for(int i=0;i<foodStuff.getTrucks().size();i++){

                    if(foodStuff.getTrucks().get(i).getTruckName().equals(foodStuff.getTruckByID(truckID).getTruckName())){

                        LocationPoints locationPoints = new LocationPoints(date,time,location,stoppingTime);
                        foodStuff.getTrucks().get(i).getLocationPoints().add(locationPoints);

                    }
                }
                Log.v("ANANA",foodStuff.getTrucks().get(1).getLocationPoints().get(0).getDate());
            }

        }
        catch(Exception e){

        }





    }

    public FoodStuff getFoodStuff() {
        return foodStuff;
    }
}
