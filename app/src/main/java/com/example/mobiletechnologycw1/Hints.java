package com.example.mobiletechnologycw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class Hints extends AppCompatActivity {

    ImageView carView;
    Button submitHintsButton;
    //String to be manipulated with - and users inputs;
    String displayAnswer ="";
    int counter = 0; // to store users goes
    int goes = 0; //saves how many times the user for the wrong letter


    //Creating an array with all car brands
    String[] cars = {"Audi", "Bentley", "BMW", "Fiat", "Ford", "Honda", "Hyundai", "jaguar", "Mercedes", "Toyota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);

        //Getting reference for ImageView, editText, textView and button
        carView = (ImageView) findViewById(R.id.imageViewCarHints);
        TextView textViewHintsCar = (TextView) findViewById(R.id.textViewCarHints);
        TextView textViewCarAnswer = (TextView)findViewById(R.id.textViewCarHintAnswer);
        EditText editTextUserInput = (EditText) findViewById(R.id.editTextUserInput);
        Button buttonSubmitHints = (Button)findViewById(R.id.buttonSubmitHints);
        TextView textViewCorrectBrand = (TextView) findViewById(R.id.textViewhintsCorrectBrand);


        //calling random number method to select random car brand and random car from location in phones sdcard
        String brand = cars[RandomNumber()];
        String fileName = "/sdcard/images/" + brand + "/" + brand + RandomNumber() +".jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        carView.setImageBitmap(bitmap);
        System.out.println("brand" + brand);

        //saving car into a string and making all char Upper case
        String answer = brand.toUpperCase();

        System.out.println("answer upper" + answer);


        //String that will display to user
        String carDisplayed;

        for (int i = 0; i < answer.length(); i++) {
            displayAnswer += "-"; //fills displayAnswer string with '-'
        }
        System.out.println("answer test " + displayAnswer);
        textViewHintsCar.setText(displayAnswer); //Setting textView with - to correspond with how many letters is in the brand of car

        buttonSubmitHints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting users input from editText and making users input uppercase
                String userChoice = editTextUserInput.getText().toString().toUpperCase();

                System.out.println("user input upper" + userChoice);
                //only selects 1st char inputted by user
                char userInput = userChoice.charAt(0);

                int count = 0;


                for (int i = 0; i < answer.length(); i++){

                    if(answer.charAt(i) == userInput){ //compares to see if char is in string
                        displayAnswer = swapChar(i, userInput, displayAnswer); //replace char at position in string
                        textViewHintsCar.setText(displayAnswer); //setting textView to users inputs if correct
                        if(textViewHintsCar.getText().toString() != answer){
                            textViewCarAnswer.setText(""); //resets to null if there is a correct answer to remove "Wrong" if the previous guess was wrong
                        }

                        count++;
                        textViewHintsCar.getText().toString();

                        System.out.println("Correct");
                        System.out.println("The location =" + i);
                        System.out.println("displayAnswer =" + displayAnswer);
                        System.out.println("answer =" + answer);
                        System.out.println("answer from text view " + textViewHintsCar.getText().toString());

                    }


                    // if wrong answer is giving then if statement is activated to show wrong
                    if(count < 1){
                             textViewCarAnswer.setText("WRONG!");
                            textViewCarAnswer.setTextColor(Color.RED);

                        System.out.println("count " + count);

                    }

                }

               //if statement is activated when all - are gone and just the brand is displayed to the user
                System.out.println("statement" + textViewHintsCar.getText().toString());
                if(textViewHintsCar.getText().toString().equals(answer)){
                    textViewCarAnswer.setText("CORRECT!");
                    textViewCarAnswer.setTextColor(Color.parseColor("#7CB06D"));
                    buttonSubmitHints.setText("Next"); //Changes button to Next once user has submitted there selection


                    //When button is changed to next and clicked activity restarts
                    buttonSubmitHints.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(getIntent());
                        }
                    });

                    System.out.println("IN if statement" + textViewHintsCar.getText().toString());
                }
                System.out.println("New answer " + displayAnswer);

                if(textViewCarAnswer.getText().toString().equals("WRONG!")){
                    goes++; // increments if user puts in the wrong answer
                }

                //if statement is activated if the user has 3 wrong answers
                if(goes == 3){
                    textViewCarAnswer.setText("WRONG!");
                    textViewCarAnswer.setTextColor(Color.RED);

                    buttonSubmitHints.setText("Next"); //Changes button to Next once user has submitted there selection
                    textViewCorrectBrand.setText(answer);
                    textViewCorrectBrand.setTextColor(Color.YELLOW);
                    System.out.println("answer " + answer);

                    buttonSubmitHints.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(getIntent());
                        }
                    });
                }
                System.out.println("goes " + goes);
            }
        });
        System.out.println("counter " + counter);
    }

    //Function that generates random number between 0-9
    public int RandomNumber (){
        int Number = new Random().nextInt(10);
        return Number;
    }

    //Method to replace char at position in string
    public String swapChar(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
}