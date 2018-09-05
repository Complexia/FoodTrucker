package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.s3399752.foodtrucker.utils.Factory;

public class Activity6 extends AppCompatActivity {
    private LayoutInflater inflater;
    private LinearLayout layout;
    private LinearLayout layout1;

//    private TextView text1;
//    private TextView text2;
//    private TextView text3;
//    private TextView text4;
//    private TextView text5;
//    private TextView text6;
//    private Button removeMeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //layout = findViewById(R.id.layoutLinear7); //without ScrollView

        layout1 = findViewById(R.id.layoutLinear8); //with ScrollView




        for(int i=0;i< Factory.meetUps.size();i++){
            Log.v("LK",Integer.toString(Factory.meetUps.size()));
            TextView text1 = (TextView)inflater.inflate(R.layout.texts,null);
            TextView text2 = (TextView)inflater.inflate(R.layout.texts,null);
            TextView text3 = (TextView)inflater.inflate(R.layout.texts,null);
            TextView text4 = (TextView)inflater.inflate(R.layout.texts,null);
            TextView text5 = (TextView)inflater.inflate(R.layout.texts,null);
            TextView text6 = (TextView)inflater.inflate(R.layout.texts,null);

            text1.setText("Event " + Integer.toString((i+1)));
            text2.setText(Factory.meetUps.get(i).getTruckName());
            text3.setText(Factory.meetUps.get(i).getDate());
            text4.setText(Factory.meetUps.get(i).getTime());
            text5.setText(Factory.meetUps.get(i).getLocation());
            text6.setText("--------------------");
            Button removeMeet = (Button)inflater.inflate(R.layout.buttons,null);
            removeMeet.setText("Remove event");

            layout1.addView(text1);
            layout1.addView(text2);
            layout1.addView(text3);
            layout1.addView(text4);
            layout1.addView(text5);
            layout1.addView(removeMeet);
            layout1.addView(text6);
        }


    }
}
