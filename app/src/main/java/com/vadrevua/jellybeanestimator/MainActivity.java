package com.vadrevua.jellybeanestimator;
// Aditya Vadrevu
// CMSC 355 Spring 2017
// Professor Duke
// Assignment #2
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {
    EditText lengthUserInput, diameterUserInput, jarSizeUserInput;
    TextView answerText;
    double lengthNum, diameterNum, jarSizeNum, volumeOfSingleBean, jellyGuess;
    final double LOAD_FACTOR = .54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lengthUserInput = (EditText) findViewById(R.id.lengthInput);  //get info from Radius text field
        diameterUserInput = (EditText) findViewById(R.id.diameterInput); //get info from Diameter text field
        jarSizeUserInput = (EditText) findViewById(R.id.jarsizeInput); //get info from Jar Size text field
        answerText = (TextView) findViewById(R.id.answerLabel); //answer label so we can change values
        Button solveBeansButton = (Button) findViewById(R.id.resultButton);


        solveBeansButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               try {
                   lengthNum = Double.parseDouble(lengthUserInput.getText().toString());
                   diameterNum = Double.parseDouble(diameterUserInput.getText().toString());
                   jarSizeNum = Double.parseDouble(jarSizeUserInput.getText().toString());
               } catch (NumberFormatException e) {
                   Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                   //answerText.setText("Enter Valid Numbers");
               }
               if (lengthNum < 0 || diameterNum < 0 || jarSizeNum < 0) {
                   Toast.makeText(getApplicationContext(), "Can't have negative values", Toast.LENGTH_LONG).show();
               } else {
                   volumeOfSingleBean = (3.14159265 / 6) * (diameterNum * diameterNum) * (lengthNum);
                   jellyGuess = (LOAD_FACTOR * jarSizeNum) / volumeOfSingleBean;
                   int intJellyGuess = (int) (jellyGuess);
                   answerText.setText("My guess is " + intJellyGuess + " Jelly Beans");
               }
           }
        });
    }
}
