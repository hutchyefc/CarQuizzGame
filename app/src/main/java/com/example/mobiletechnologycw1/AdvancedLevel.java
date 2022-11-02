package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {

    String[] cars = {"Audi", "Bentley", "BMW", "Fiat", "Ford", "Honda", "Hyundai", "jaguar", "Mercedes", "Toyota"};
    int attempt = 0; // making variable to store users attempts
    int score = 0; // variable to keep user's points for every correct answer

    //variables to help control user only getting 1 point per correct answer
    int tempScoreCar1 = 0;
    int tempScoreCar2 = 0;
    int tempScoreCar3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        //Getting reference for ImageView, textView, EditText and button
        ImageView imageViewCar1 = (ImageView) findViewById(R.id.imageViewCarAdvanced1);
        ImageView imageViewCar2 = (ImageView) findViewById(R.id.imageViewCarAdvanced2);
        ImageView imageViewCar3 = (ImageView) findViewById(R.id.imageViewCarAdvanced3);
        EditText editTextCar1 = (EditText) findViewById(R.id.editTextCar1);
        EditText editTextCar2 = (EditText) findViewById(R.id.editTextCar2);
        EditText editTextCar3 = (EditText) findViewById(R.id.editTextCar3);
        TextView textViewCar1Answer = (TextView) findViewById(R.id.textViewCar1Answer);
        TextView textViewCar2Answer = (TextView) findViewById(R.id.textViewCar2Answer);
        TextView textViewCar3Answer = (TextView) findViewById(R.id.textViewCar3Answer);
        TextView textViewScore = (TextView) findViewById(R.id.textViewScore);
        TextView answer = (TextView) findViewById(R.id.textViewCarAdvancedAnswer);
        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmitAdvanced);

        //getting random car brands and saving them in a string
        String brand1 = cars[RandomNumber()];
        String brand2 = cars[RandomNumber()];
        String brand3 = cars[RandomNumber()];

        //changing car brands out if they are the same
        while (brand1.equals(brand2) || brand1.equals(brand3) || brand2.equals(brand3)) {
            brand1 = cars[RandomNumber()];
            brand2 = cars[RandomNumber()];
            brand3 = cars[RandomNumber()];
        }

        //setting random imageView in the activity and making the brand of car all uppercase
        randomImage(imageViewCar1, brand1);
        String carBrand1 = brand1.toUpperCase();
        System.out.println("Brand1 " + carBrand1);

        randomImage(imageViewCar2, brand2);
        String carBrand2 = brand2.toUpperCase();
        System.out.println("Brand2 " + carBrand2);

        randomImage(imageViewCar3, brand3);
        String carBrand3 = brand3.toUpperCase();
        System.out.println("Brand3 " + carBrand3);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //getting users input from editText and making users input uppercase
                String userChoiceCar1 = editTextCar1.getText().toString().toUpperCase();
                System.out.println("car 1 " + userChoiceCar1);
                String userChoiceCar2 = editTextCar2.getText().toString().toUpperCase();
                System.out.println("car 2 " + userChoiceCar1);
                String userChoiceCar3 = editTextCar3.getText().toString().toUpperCase();
                System.out.println("car 3 " + userChoiceCar1);

                System.out.println("temp " +tempScoreCar1);

                if(userChoiceCar1.equals(carBrand1)){
                    editTextCar1.setTextColor(Color.parseColor("#7CB06D"));
                    editTextCar1.setKeyListener(null); //makes text uneditable after correct answer
                    System.out.print("CORRECT");

                    //if statement to give the user 1 point for every correct answer
                    if(score >= 0 && tempScoreCar1 <= 0){
                        score++;
                        tempScoreCar1++;
                        textViewScore.setText(String.valueOf(score) + " pts");
                    }
                }else{
                    editTextCar1.setTextColor(Color.RED); // sets text red if guess is wrong

                }
                if(userChoiceCar2.equals(carBrand2)){
                    editTextCar2.setTextColor(Color.parseColor("#7CB06D"));
                    editTextCar2.setKeyListener(null); //makes text uneditable after correct answer
                    System.out.print("CORRECT");

                    //if statement to give the user 1 point for every correct answer
                    if(score >= 0 && tempScoreCar2 <= 0){
                        score++;
                        tempScoreCar2++;
                        textViewScore.setText(String.valueOf(score)  + " pts");
                    }
                }else{
                    editTextCar2.setTextColor(Color.RED); // sets text red if guess is wrong

                }
                if(userChoiceCar3.equals(carBrand3)){
                    editTextCar3.setTextColor(Color.parseColor("#7CB06D"));
                    editTextCar3.setKeyListener(null); //makes text uneditable after correct answer
                    System.out.print("CORRECT");

                    //if statement to give the user 1 point for every correct answer
                    if(score >= 0 && tempScoreCar3 <= 0){
                        score++;
                        tempScoreCar3++;
                        textViewScore.setText(String.valueOf(score) + " pts");
                    }
                }else{
                    editTextCar3.setTextColor(Color.RED); // sets text red if guess is wrong

                }

                //incrementing attempt counter by 1 every time a user clicks submit and 1 of there inputs are incorrect
                if(userChoiceCar1 != carBrand1 || userChoiceCar2 != carBrand2 || userChoiceCar3 != carBrand3) {
                    attempt++;
                }
                //user has 3 attempts then wrong will appear on the screen and the name of the brands which the user got wrong, the button will then change to next which will let the user restart the activity
                if(attempt == 3){
                    buttonSubmit.setText("Next");
                    answer.setText("WRONG!");
                    answer.setTextColor(Color.RED);

                    //setting textView to correct brand and changing font to yellow
                if(userChoiceCar1 != carBrand1){
                    textViewCar1Answer.setText(carBrand1);
                    textViewCar1Answer.setTextColor(Color.YELLOW);
                    }
                    if(userChoiceCar2 != carBrand2){
                        textViewCar2Answer.setText(carBrand2);
                        textViewCar2Answer.setTextColor(Color.YELLOW);
                    }
                    if(userChoiceCar3 != carBrand3){
                        textViewCar3Answer.setText(carBrand3);
                        textViewCar3Answer.setTextColor(Color.YELLOW);
                    }

                    //if user guesses correct car brand for car then resetting textview to null so car brand does not display in yellow to user
                    if(userChoiceCar1.equals(carBrand1)){
                        textViewCar1Answer.setText("");
                    }
                    if(userChoiceCar2.equals(carBrand2)){
                        textViewCar2Answer.setText("");
                    }
                    if(userChoiceCar3.equals(carBrand3)){
                        textViewCar3Answer.setText("");
                    }

                    //When button is clicked it restarts the activity
                    buttonSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(getIntent());
                        }
                    });

                }
                //checks if all 3 users inputs are correct then changes the submit button to "Next"
                if(userChoiceCar1.equals(carBrand1) && userChoiceCar2.equals(carBrand2) && userChoiceCar3.equals(carBrand3)){
                    buttonSubmit.setText("Next");
                    answer.setText("CORRECT");
                    answer.setTextColor(Color.parseColor("#7CB06D"));


                    //When button is clicked it restarts the activity
                    buttonSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(getIntent());
                        }
                    });
                }

                   System.out.print("works inside method " + attempt);

            }
        });
        System.out.println("brand " + brand1);
        System.out.println("brand " + brand2);
        System.out.println("brand " + brand3);
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