package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.s3399752.foodtrucker.utils.FoodStuff;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        FoodStuff foodStuff = new FoodStuff(this);
        foodStuff.loadFile();
        String truckName = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            truckName = extras.getString("name");
        }

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = findViewById(R.id.layoutLinear);

        TextView name = (TextView)inflater.inflate(R.layout.texts,null);
        name.setText(truckName);
        layout.addView(name);

        














    }
}
