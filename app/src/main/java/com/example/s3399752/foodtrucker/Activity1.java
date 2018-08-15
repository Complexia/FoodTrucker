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

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        ArrayList<Button> buttons = new ArrayList<Button>();
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for(int i=0;i<30;i++){
            Button button = (Button)inflater.inflate(R.layout.buttons,null);
            button.setId(i+1);
            button.setText("Hello" + (i+1));
            button.setHeight(200);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Activity1.this,MainActivity.class
                    ));
                }
            });
            buttons.add(button);
        }

        LinearLayout layout = findViewById(R.id.layoutLinear);
        for(int i=0;i<buttons.size();i++){
            layout.addView(buttons.get(i));
            TextView text = (TextView)inflater.inflate(R.layout.texts,null);
            text.setText("world");
            layout.addView(text);
        }











    }
}
