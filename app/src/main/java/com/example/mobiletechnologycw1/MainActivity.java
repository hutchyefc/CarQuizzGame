package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "welcome",
                Toast.LENGTH_LONG).show();

        //Get reference of Buttons
        Button button_about = findViewById(R.id.buttonAbout);
        Button button_new_car_game = findViewById(R.id.buttonNewCarGame);


        //perform setOnclickListener even on buttonAbout
        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loads fragment with information about student ie student ID and StudentName
                loadFragment(new aboutFragment());
            }
        });

        //when button is clicked OnClickListener is called and opens CarGame Activity
        button_new_car_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CarGame.class));
            }
        });
    }

    private void loadFragment(Fragment fragment){
        //creates a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //creates a FragmentTransaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //replaces the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        //Save's changes
        fragmentTransaction.commit();
    }


}