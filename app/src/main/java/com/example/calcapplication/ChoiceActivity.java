package com.example.calcapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    private final String TAG = "ChoiceActivity";
    private TextView mChoiceTextView;
    private CardView mGeometryCardView;
    private CardView mFunctionCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        String choicePage = "Welcome at choice Page. " +
                "\nWhat would you like to calc?";

        mChoiceTextView = findViewById(R.id.choice_tv);
        mGeometryCardView = findViewById(R.id.geometry_card);
        mFunctionCardView = findViewById(R.id.function_card);

        mGeometryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GeometricActivity.class);
                startActivity(intent);
            }
        });

        mFunctionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FunctionActivity.class);
                startActivity(intent);
            }
        });


        mChoiceTextView.setText(choicePage);


    }
}
