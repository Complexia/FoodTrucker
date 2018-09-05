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

import com.example.s3399752.foodtrucker.utils.FoodStuff;
import com.example.s3399752.foodtrucker.utils.Truck;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private LayoutInflater inflater;
    private TextView text1;
    LinearLayout layout;
    Button addTrackablesButton;
    private ArrayList<Button> buttons;
    private FoodStuff foodStuff;
    private TextView text2;
    private ArrayList<Truck> trackingTrucks;
    private Button myMeetups;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.layoutLinear3);
        text1 = (TextView)inflater.inflate(R.layout.texts,null);
        text1.setText("No trackables at the moment...");
        buttons = new ArrayList<>();
        text2 = (TextView)inflater.inflate(R.layout.texts,null);
        text2.setText("Click on the trucks to begin tracking them...");

        addTrackablesButton = (Button)inflater.inflate(R.layout.buttons,null);
        addTrackablesButton.setText("Track some trucks");
        Bundle extra = getIntent().getExtras();
        String currentTruck = "";
        if(extra != null){
           currentTruck =  extra.getString("currentTruck");

        }
        Bundle newExtra = getIntent().getBundleExtra("newTrackingTracks");
        if(newExtra != null){
            trackingTrucks = (ArrayList<Truck>)newExtra.getSerializable("trackingTracks");
        }
        if(trackingTrucks == null){
            Log.v("AASDDS","HAHAHA");
        }
        Bundle extras = getIntent().getBundleExtra("extra");
        if(extras != null) {
            trackingTrucks  = (ArrayList<Truck>)extras.getSerializable("trackingTracks");
            addTrackablesButton.setText("Track more trucks");
            myMeetups = (Button)inflater.inflate(R.layout.buttons,null);
            myMeetups.setText("My scheduled meetups");
            myMeetups.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity2.this,Activity6.class);
                    startActivity(intent);
                }
            });
            layout.addView(myMeetups);
            TextView text3 = (TextView)inflater.inflate(R.layout.texts,null);
            text3.setText("Your trackables: ");
            layout.addView(text3);




        }
        if(trackingTrucks != null){
            for(int i=0;i<trackingTrucks.size();i++){
                final Button button = (Button)inflater.inflate(R.layout.buttons,null);
                button.setText(trackingTrucks.get(i).getTruckName());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity2.this,Activity3.class);
                        intent.putExtra("truckName",button.getText());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("trackingTracks",trackingTrucks);
                        intent.putExtra("bundle",bundle);
                        startActivity(intent);
                    }
                });
                buttons.add(button);
                layout.addView(button);
            }
        }

        if(trackingTrucks == null){
            layout.addView(text1);
        }





        addTrackablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                intent.putExtra("checker",1);
                Bundle extra = new Bundle();
                extra.putSerializable("trackingTrucks",trackingTrucks);
                intent.putExtra("extra",extra);
                startActivity(intent);
            }
        });

        layout.addView(addTrackablesButton);





    }

    public void loadButtons(){
        layout.removeAllViews();
        layout.addView(text2);
        for(int i=0;i<buttons.size();i++){

                layout.addView(buttons.get(i));
            }



        }

}
