package com.example.calcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private TextView mWelcomeTextView;
    private TextView mSomeInfoTextView;
    private TextView mFooter;
    private Button goNextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String someText = "Welcome in calcApp that is app made to calculate some geometry area, capacity. In app we " +
                "have possibility to calculate quadratic and linear function";
        String footer = "Application is made by Arkadiusz Tarnowski";

        mWelcomeTextView = findViewById(R.id.welcome_tv);
        mSomeInfoTextView = findViewById(R.id.some_info_tv);
        mFooter = findViewById(R.id.made_by);
        goNextButton = findViewById(R.id.go_next);

        mSomeInfoTextView.setText(someText);
        mFooter.setText(footer);

        goNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChoiceActivity.class);
                startActivity(intent);
                Log.v(TAG,"On click: Go to next activity");
            }
        });


    }


}
