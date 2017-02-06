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
    EditText radiusUserInput, diameterUserInput, jarSizeUserInput;
    TextView answerText;
    int radiusNum, diameterNum, jarSizeNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiusUserInput = (EditText) findViewById(R.id.radiusInput);  //get info from Radius text field
        diameterUserInput = (EditText) findViewById(R.id.diameterInput); //get info from Diameter text field
        jarSizeUserInput = (EditText) findViewById(R.id.jarsizeInput); //get info from Jar Size text field
        answerText = (TextView) findViewById(R.id.answerLabel); //answer label so we can change values
        Button solveBeansButton = (Button) findViewById(R.id.resultButton);


        solveBeansButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               try {
                   radiusNum = Integer.parseInt(radiusUserInput.getText().toString());
                   diameterNum = Integer.parseInt(diameterUserInput.getText().toString());
                   jarSizeNum = Integer.parseInt(jarSizeUserInput.getText().toString());
               } catch (NumberFormatException e) {
                   Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                   //answerText.setText("Enter Valid Numbers");
               }

           }
        });
    }
}
