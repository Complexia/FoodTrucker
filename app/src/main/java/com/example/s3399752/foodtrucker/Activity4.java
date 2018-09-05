package com.example.s3399752.foodtrucker;

import android.content.Context;
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

import com.example.s3399752.foodtrucker.utils.FoodStuff;
import com.example.s3399752.foodtrucker.utils.LocationStuff;

public class Activity4 extends AppCompatActivity {


    private LayoutInflater inflater;
    private TextView text1;
    private TextView textEnterDate;
    private TextView textEnterTime;
    LinearLayout layout;
    private EditText dateIn;
    private EditText timeIn;
    private Button locationButton;
    private FoodStuff foodStuff;
    private LocationStuff locationStuff;
    String truckName;
    String truckID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.layoutLinear5);
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
        text1.setText("Enter date and time: ");

        textEnterDate = (TextView)inflater.inflate(R.layout.texts,null);
        textEnterDate.setText("Enter date: ");

        dateIn = (EditText)inflater.inflate(R.layout.input_text, null);
        dateIn.setText("DD/MM/YY");
        dateIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dateIn.getText().clear();
                return false;
            }
        });

        textEnterTime = (TextView)inflater.inflate(R.layout.texts,null);
        textEnterTime.setText("Enter time: ");

        timeIn = (EditText)inflater.inflate(R.layout.input_text, null);
        timeIn.setText("HH:MM");
        timeIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                timeIn.getText().clear();
                return false;
            }
        });

        locationButton = (Button)inflater.inflate(R.layout.buttons,null);
        locationButton.setText("Search location: ");

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(locationStuff.getFoodStuff().getTruckByID(truckID).getDateLocation() == null){
                    Log.v("AJAX",locationStuff.getFoodStuff().getTruckByID(truckID).getTruckName());
                }

                if(textEnterDate.getText().equals(locationStuff.getFoodStuff().getTruckByID(truckID).getDateLocation())){

                }
            }
        });


        layout.addView(textEnterDate);
        layout.addView(dateIn);
        layout.addView(textEnterTime);
        layout.addView(timeIn);
        layout.addView(locationButton);
    }
}
