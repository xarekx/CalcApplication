package com.example.calcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    private final String TAG = "ChoiceActivity";
    private TextView mChoiceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        String choicePage = "Welcome at choice Page. " +
                "\nWhat would you like to calc?";

        mChoiceTextView = findViewById(R.id.choice_tv);

        mChoiceTextView.setText(choicePage);
    }
}
