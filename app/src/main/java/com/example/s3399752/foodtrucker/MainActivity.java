package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout layout = findViewById(R.id.layoutLinear);
        ArrayList<Button> buttons = new ArrayList<>();
        for(int i=0;i<10;i++){
            Button btn = (Button)inflater.inflate(R.layout.buttons,null);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this,Activity1.class));
                }
            });
            buttons.add(btn);

        }
        for(int i=0;i<buttons.size();i++){
            layout.addView(buttons.get(i));

        }
        TextView text1 = (TextView)inflater.inflate(R.layout.texts,null);

        text1.setText("Malaysian Delights");
        //layout.addView(text1);

//        for(int i=buttons.size()/2;i<buttons.size();i++){
//            layout.addView(buttons.get(i));
//
//        }

        TextView text2 = (TextView)inflater.inflate(R.layout.texts,null);
        text1.setText("Wonder Thai");
        //layout.addView(text2);



    }
}
//http://izvornikod.com/Blog/tabid/82/EntryId/8/Creating-Android-button-with-image-and-text-using-relative-layout.aspx
