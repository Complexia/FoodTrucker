package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.s3399752.foodtrucker.utils.Truck;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private LayoutInflater inflater;
    private TextView text1;
    LinearLayout layout;
    private String currentTruck;
    private Button meetButton;
    private Button locationButton;
    private Button removeButton;
    private ArrayList<Truck> trackingTrucks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.layoutLinear4);
        trackingTrucks = new ArrayList<Truck>();
        text1 = (TextView)inflater.inflate(R.layout.texts,null);
        meetButton = (Button)inflater.inflate(R.layout.buttons,null);
        locationButton = (Button)inflater.inflate(R.layout.buttons,null);
        removeButton = (Button)inflater.inflate(R.layout.buttons,null);
        meetButton.setText("Schedule a meet");
        locationButton.setText("Current location");
        removeButton.setText("Stop tracking truck");
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this,Activity2.class);
                Bundle bundle = getIntent().getBundleExtra("bundle");
                trackingTrucks = (ArrayList<Truck>)bundle.getSerializable("trackingTracks");


                for(int i=0;i<trackingTrucks.size();i++){
                    if(trackingTrucks.get(i).getTruckName().equals(currentTruck)){

                        trackingTrucks.remove(i);

                    }
                }
                bundle.putSerializable("trackingTracks",trackingTrucks);
                intent.putExtra("newTrackingTracks",trackingTrucks);

                startActivity(intent);

            }
        });
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            currentTruck = extras.getString("truckName");
            text1.setText(currentTruck);
            layout.addView(text1);
            layout.addView(locationButton);
            layout.addView(meetButton);
            layout.addView(removeButton);

        }
    }
}
