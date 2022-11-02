package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_game);

        //Get reference of Button
        Button button_brand = (Button) findViewById(R.id.identifyBrandBtn);
        Button button_hints = (Button) findViewById(R.id.hintsBtn);
        Button button_cars = (Button) findViewById(R.id.identifyCarBtn);
        Button button_advanced = (Button) findViewById(R.id.advancedBtn);

        //when button is clicked OnClickListener is called and opens IdentifyTheBrand Activity
        button_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CarGame.this, IdentifyTheBrand.class));
            }
        });

        //when button is clicked OnClickListener is called and opens Hints Activity
        button_hints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CarGame.this, Hints.class));
            }
        });

        //when button is clicked OnClickListener is called and opens IdentifyTheCar Activity
        button_cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CarGame.this, IdentifyTheCar.class));
            }
        });

        //when button is clicked OnClickListener is called and opens AdvancedLevel Activity
        button_advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CarGame.this, AdvancedLevel.class));
            }
        });
    }
}