package com.example.calcapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.calcapplication.LinearFunction.LinearActivity;
import com.example.calcapplication.QuadraticFunction.QuadraticActivity;

public class FunctionActivity extends AppCompatActivity {

    private final String TAG = "FunctionActivity";
    private CardView mLinearCardView;
    private CardView mQuadraticCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        mLinearCardView = findViewById(R.id.linear_card);
        mQuadraticCardView = findViewById(R.id.quadratic_card);

        mLinearCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LinearActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }
        });

        mQuadraticCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuadraticActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }
        });

    }

}
