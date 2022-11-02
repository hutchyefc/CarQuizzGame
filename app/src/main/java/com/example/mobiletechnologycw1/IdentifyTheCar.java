package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class IdentifyTheCar extends AppCompatActivity {

    //Creating an array with all car brands
    String[] cars = {"Audi", "Bentley", "BMW", "Fiat", "Ford", "Honda", "Hyundai", "jaguar", "Mercedes", "Toyota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car);

        //Getting reference for ImageView, textView and button
        ImageView imageViewCar1 = (ImageView) findViewById(R.id.imageViewCar1);
        ImageView imageViewCar2 = (ImageView) findViewById(R.id.imageViewCar2);
        ImageView imageViewCar3 = (ImageView) findViewById(R.id.imageViewCar3);
        Button nextButton = (Button) findViewById(R.id.buttonCarNext);
        TextView textViewCarAnswer = (TextView) findViewById(R.id.textViewCarAnswer);
        TextView textViewCarBrand = (TextView) findViewById(R.id.textViewCarBrand);

        //getting random car brands and saving them in a string
        String brand1 = cars[RandomNumber()];
        String brand2 = cars[RandomNumber()];
        String brand3 = cars[RandomNumber()];

        System.out.println("brand car first "+ brand1 + brand2 + brand3); //printing to the screen to compare brands with swapping out with if statement

        //changing car brands out if they are the same
        while (brand1.equals(brand2) || brand1.equals(brand3) || brand2.equals(brand3)) {
            brand1 = cars[RandomNumber()];
            brand2 = cars[RandomNumber()];
            brand3 = cars[RandomNumber()];
        }

        System.out.println("brand car after/if swapped "+ brand1 + brand2 + brand3); // printing to the screen to compare with first saving of brands

        //3 random cars of different brands put into the 3 image views also saving as string to compare when image clicked
        randomImage(imageViewCar1, brand1);
        String carBrand1 = brand1;

        randomImage(imageViewCar2, brand2);
        String carBrand2 = brand2;

        randomImage(imageViewCar3, brand3);
        String carBrand3 = brand3;

        //creating array of the 3 randomly selected brands of car then randomly choosing between the 3 to show the user on the screen
        String[] brandsArray = {brand1, brand2, brand3};

        //getting random number between 0-2 and using it to set textView with random brand which is in the array
        int Number = new Random().nextInt(3);
        String correctCar = brandsArray[Number];
        textViewCarBrand.setText(correctCar);
        //textViewCarBrand.setText(brandsArray[Number]);
        System.out.println("Correct car " + correctCar);

        //called when 1st image is clicked and compares correct brand with the picture user clicked on and gives feedback with correct or wrong
        imageViewCar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carBrand1.equals(correctCar)){
                    textViewCarAnswer.setText("CORRECT");
                    textViewCarAnswer.setTextColor(Color.parseColor("#7CB06D"));
                }else {
                    textViewCarAnswer.setText("WRONG!");
                    textViewCarAnswer.setTextColor(Color.RED);
                }
                imageViewCar1.setClickable(false); // makes image's unclickable
                imageViewCar2.setClickable(false);
                imageViewCar3.setClickable(false);
            }
        });
        //called when 2nd image is clicked and compares correct brand with the picture user clicked on and gives feedback with correct or wrong
        imageViewCar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carBrand2.equals(correctCar)){
                    textViewCarAnswer.setText("CORRECT");
                    textViewCarAnswer.setTextColor(Color.parseColor("#7CB06D"));
                }else {
                    textViewCarAnswer.setText("WRONG!");
                    textViewCarAnswer.setTextColor(Color.RED);
                }
                imageViewCar1.setClickable(false); // makes image's unclickable
                imageViewCar2.setClickable(false);
                imageViewCar3.setClickable(false);
            }
        });
        //called when 3rd image is clicked and compares correct brand with the picture user clicked on and gives feedback with correct or wrong
        imageViewCar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carBrand3.equals(correctCar)){
                    textViewCarAnswer.setText("CORRECT");
                    textViewCarAnswer.setTextColor(Color.parseColor("#7CB06D"));
                }else {
                    textViewCarAnswer.setText("WRONG!");
                    textViewCarAnswer.setTextColor(Color.RED);
                }
                imageViewCar1.setClickable(false); // makes image's unclickable
                imageViewCar2.setClickable(false);
                imageViewCar3.setClickable(false);
            }
        });

        //Button to restart activity which will only activate once the user has tried to click on the image and has got feedback from the system as CORRECT or WRONG!
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textViewCarAnswer.getText().equals("CORRECT") || textViewCarAnswer.getText().equals("WRONG!")){
                    startActivity(getIntent());
                }
            }
        });

    }

    //Function that generates random number between 0-9
    public int RandomNumber (){
        int Number = new Random().nextInt(10);
        return Number;
    }

    //method to randomly select car image's
    public void randomImage(ImageView carView, String brand){
        String fileName = "/sdcard/images/" + brand + "/" + brand + RandomNumber() +".jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        carView.setImageBitmap(bitmap);
        System.out.println("brand" + brand);
    }

}