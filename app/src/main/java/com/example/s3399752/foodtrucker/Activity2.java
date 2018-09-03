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

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private LayoutInflater inflater;
    private TextView text1;
    LinearLayout layout;
    Button addTrackablesButton;
    private ArrayList<Button> buttons;
    private FoodStuff foodStuff;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.layoutLinear3);
        text1 = (TextView)inflater.inflate(R.layout.texts,null);
        text1.setText("No trackables at the moment...");

        text2 = (TextView)inflater.inflate(R.layout.texts,null);
        text2.setText("Click on the trucks to begin tracking them...");

        layout.addView(text1);



        addTrackablesButton = (Button)inflater.inflate(R.layout.buttons,null);
        addTrackablesButton.setText("Track some trucks");
        addTrackablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                intent.putExtra("checker",1);
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
