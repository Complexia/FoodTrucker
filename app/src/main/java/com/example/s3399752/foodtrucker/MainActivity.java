package com.example.s3399752.foodtrucker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.s3399752.foodtrucker.utils.Factory;
import com.example.s3399752.foodtrucker.utils.FoodStuff;
import com.example.s3399752.foodtrucker.utils.Truck;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FoodStuff foodStuff;
    private LayoutInflater inflater;
    private EditText searchBox;

    private ArrayList<Button> buttons;
    private LinearLayout layout;
    private LinearLayout layout1;
    private TextView text1;
    Button myTrackables;
    private int checker;
    private ArrayList<Truck> trackingTrucks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        trackingTrucks = new ArrayList<Truck>();


        foodStuff = new FoodStuff(this);
        foodStuff.loadFile();
        layout = findViewById(R.id.layoutLinear); //without ScrollView

        layout1 = findViewById(R.id.layoutLinear1); //with ScrollView
        buttons = new ArrayList<>();


        checker = 0;
        Bundle extras = getIntent().getExtras();
        Bundle extra = getIntent().getBundleExtra("extra");
        if(extras != null) {
            checker = extras.getInt("checker");



        }
        if(extra != null){
            if((ArrayList<Truck>)extra.getSerializable("trackingTrucks") != null){
                trackingTrucks = (ArrayList<Truck>)extra.getSerializable("trackingTrucks");
            }

        }



        for(int i=0;i<foodStuff.getTrucks().size();i++){
            Button btn = (Button)inflater.inflate(R.layout.buttons,null);

            final String truckName = foodStuff.getTrucks().get(i).getTruckName();
            final String truckClassification = foodStuff.getTrucks().get(i).getTruckClassification();
            final String truckWebsite = foodStuff.getTrucks().get(i).getTruckWebsite();
            btn.setText(foodStuff.getTrucks().get(i).getTruckName());
            final Button btn1 = btn;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(checker == 0){
                        Intent intent = new Intent(MainActivity.this, Activity1.class);
                        intent.putExtra("name",truckName);
                        intent.putExtra("category", truckClassification);

                        intent.putExtra("website", truckWebsite);
                        startActivity(intent);
                    }
                    else{



                        for(int j=0;j<buttons.size();j++){
                            if(buttons.get(j).getText().equals(btn1.getText())){
                                trackingTrucks.add(foodStuff.getTrucks().get(j + (foodStuff.getTrucks().size() - buttons.size())));
                                buttons.remove(j);

                                break;
                            }
                        }
                        loadButtons();

                    }

                }
            });
            buttons.add(btn);

        }
        if(checker == 1 && trackingTrucks != null){
            for(int i=0;i<buttons.size();i++){
                for(int j=0;j<trackingTrucks.size();j++){
                    if(buttons.get(i).getText().equals(trackingTrucks.get(j).getTruckName())){
                        buttons.remove(i);
                    }
                }
                if(buttons.size() == 0){
                    break;
                }
            }
        }
        text1 = (TextView)inflater.inflate(R.layout.texts,null);

        searchBox = (EditText)inflater.inflate(R.layout.input_text, null);
        searchBox.setText("Search...");

        searchBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                searchBox.getText().clear();
                return false;
            }
        });

        searchBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Log.v("EditTextG",searchBox.getText().toString());
                loadButtons();
                return false;
            }
        });


        layout.addView(searchBox);
        if(checker == 0){
            myTrackables = (Button)inflater.inflate(R.layout.buttons,null);
            myTrackables.setText("My foodtrucks");
            myTrackables.setBackgroundColor(Color.GREEN);
            myTrackables.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                }
            });

            layout.addView(myTrackables);
        }
        else{
            final Button doneButton = (Button)inflater.inflate(R.layout.buttons,null);
            doneButton.setText("Done adding trucks");
            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(trackingTrucks.isEmpty()){
                        //inform user that he needs to add trucks first
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this,Activity2.class);
                        Bundle extra = new Bundle();
                        extra.putSerializable("trackingTracks",trackingTrucks);

                        intent.putExtra("extra",extra);
                        Factory.setTrackingTrucks(trackingTrucks);

                        startActivity(intent);


                    }
                }
            });
            layout.addView(doneButton);
        }



        text1.setText("All:");
        layout.addView(text1);


        loadButtons();






    }

    public void loadButtons(){
        layout1.removeAllViews();


        for(int i=0;i<buttons.size();i++){
            Log.v("EditTextG",searchBox.getText().toString());
            if((searchBox.getText().toString().equals("Search...")) ||
                    (searchBox.getText().toString().isEmpty())){

                layout1.addView(buttons.get(i));
            }
            else{
                if((foodStuff.getTrucks().get(i).getTruckName().toLowerCase().contains(searchBox.getText().toString().toLowerCase())) ||
                        (foodStuff.getTrucks().get(i).getTruckClassification().toLowerCase().contains(searchBox.getText().toString().toLowerCase())) ){
                    layout1.addView(buttons.get(i));
                }
            }


        }
    }
}
//http://izvornikod.com/Blog/tabid/82/EntryId/8/Creating-Android-button-with-image-and-text-using-relative-layout.aspx
