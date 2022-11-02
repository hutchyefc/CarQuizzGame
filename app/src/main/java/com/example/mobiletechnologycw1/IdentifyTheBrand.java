package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IdentifyTheBrand extends AppCompatActivity{

    ImageView carView;
    Button submitBrandButton;
    Spinner spin;
    //Creating an array with all car brands
    String[] cars = {"Audi", "Bentley", "BMW", "Fiat", "Ford", "Honda", "Hyundai", "jaguar", "Mercedes", "Toyota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_brand);

        //Getting reference for ImageView, dropdown, textView and button
        carView = (ImageView) findViewById(R.id.imageViewCarBrand);
        spin = (Spinner) findViewById(R.id.spinner);
        submitBrandButton = (Button) findViewById(R.id.buttonSubmitBrand);
        TextView textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        TextView textViewBrand = (TextView) findViewById(R.id.textViewCorrectBrand);

        //calling random number method to select random car brand and random car from location in phones sdcard
        String brand = cars[RandomNumber()];
        String fileName = "/sdcard/images/" + brand + "/" + brand + RandomNumber() +".jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        carView.setImageBitmap(bitmap);
        System.out.println("brand" + brand);
        System.out.println("location " + fileName);

        //populates dropdown menu from array cars
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cars);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        //Once button is clicked validation happens to make sure users selection is correct
        submitBrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gets users selection
                String brandSelection = spin.getSelectedItem().toString();
                System.out.println("Brand test = " + brandSelection);//using print statement to test on logcat brand is correct
                //checks users selection against actual brand of car
                if (submitBrandButton.getText().equals("SUBMIT")){
                    if (brand.equals(brandSelection)){
                        textViewAnswer.setText("CORRECT");
                        textViewAnswer.setTextColor(Color.parseColor("#7CB06D"));
                    }else{
                        textViewAnswer.setText("WRONG");
                        textViewAnswer.setTextColor(Color.RED);
                        textViewBrand.setText(brand);
                        textViewBrand.setTextColor(Color.BLUE);

                    }
                    submitBrandButton.setText("Next"); //Changes button to Next once user has submitted there selection
                }else{
                    startActivity(getIntent()); //When button is changed to next and clicked activity restarts
                }
            }
        });

    }

    //Function that generates random number between 0-9
    public int RandomNumber (){
        int Number = new Random().nextInt(10);
        return Number;
    }

}

