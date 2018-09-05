package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.s3399752.foodtrucker.utils.Factory;
import com.example.s3399752.foodtrucker.utils.FoodStuff;
import com.example.s3399752.foodtrucker.utils.LocationStuff;
import com.example.s3399752.foodtrucker.utils.MeetUps;

public class Activity5 extends AppCompatActivity {
    private LayoutInflater inflater;
    private TextView text1;
    LinearLayout layout;
    private LocationStuff locationStuff;
    private String truckName;
    private String truckID;
    private FoodStuff foodStuff;
    private TextView textEnterDate;
    private TextView textEnterTime;
    private EditText dateIn;
    private EditText timeIn;
    private Button scheduleButton;
    private TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.layoutLinear6);

        foodStuff = new FoodStuff(this);
        foodStuff.loadFile();
        locationStuff = new LocationStuff(this);
        locationStuff.loadFile();
        truckName = "";
        truckID = "SD";

        Bundle extra = getIntent().getExtras();
        if(extra != null){

            truckName = extra.getString("truckName");

            for(int i=0;i<foodStuff.getTrucks().size();i++){

                if(foodStuff.getTrucks().get(i).getTruckName().equals(truckName)){
                    truckID = foodStuff.getTrucks().get(i).getTruckID();

                    break;
                }
            }
        }
        text1 = (TextView)inflater.inflate(R.layout.texts,null);
        text1.setText("Meet up with " + truckName);
        layout.addView(text1);

        textEnterDate = (TextView)inflater.inflate(R.layout.texts,null);
        textEnterDate.setText("Enter date: ");

        dateIn = (EditText)inflater.inflate(R.layout.input_text,null);
        dateIn.setText("DD/MM/YYYY");
        dateIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dateIn.getText().clear();
                return false;
            }
        });
        textEnterTime = (TextView)inflater.inflate(R.layout.texts,null);
        textEnterTime.setText("Enter time: ");

        timeIn = (EditText)inflater.inflate(R.layout.input_text,null);
        timeIn.setText("H:MM:SS");
        timeIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                timeIn.getText().clear();
                return false;
            }
        });
        scheduleButton = (Button)inflater.inflate(R.layout.buttons,null);
        scheduleButton.setText("Schedule");
        locationText = (TextView)inflater.inflate(R.layout.texts,null);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.removeView(locationText);
                int check = 0;
                for(int i=0;i<locationStuff.getFoodStuff().getTruckByID(truckID).getLocationPoints().size();i++){
                    if((locationStuff.getFoodStuff().getTruckByID(truckID).getLocationPoints().get(i).getDate().equals(dateIn.getText().toString())) &&
                            (locationStuff.getFoodStuff().getTruckByID(truckID).getLocationPoints().get(i).getTime().equals(timeIn.getText().toString()))){

                        if(Integer.parseInt(locationStuff.getFoodStuff().getTruckByID(truckID).getLocationPoints().get(i).getStoppingTime()) > 0){
                            Intent intent = new Intent(Activity5.this,Activity2.class);
                            Factory.meetUps.add(new MeetUps(truckName,dateIn.getText().toString(),timeIn.getText().toString(),
                                    locationStuff.getFoodStuff().getTruckByID(truckID).getLocationPoints().get(i).getLocation()));
                            Log.v("LK",Integer.toString(Factory.meetUps.size()));
                            Bundle extra = new Bundle();
                            extra.putSerializable("trackingTracks",Factory.trackingTrucks);

                            intent.putExtra("extra",extra);

                            startActivity(intent);
                        }
                        else{


                            locationText.setText("The truck is in motion at this time");

                        }
                        check = 1;
                    }



                }
                if(check == 0){

                    locationText.setText("Truck's location at this time is unknown");
                }
                layout.addView(locationText);

            }
        });

        layout.addView(textEnterDate);
        layout.addView(dateIn);
        layout.addView(textEnterTime);
        layout.addView(timeIn);
        layout.addView(scheduleButton);
    }
}
