package com.example.calcapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.calcapplication.Area.ChooseAreaActivity;
import com.example.calcapplication.Volume.ChooseVolumeActivity;

public class GeometricActivity extends AppCompatActivity {

    private final String TAG = "Geometric Activity";
    private CardView mAreaCardView;
    private CardView mVolumeCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometric);

        mAreaCardView = findViewById(R.id.area_card);
        mVolumeCardView = findViewById(R.id.volume_card);

        mAreaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: AreaActivity");
                Intent intent = new Intent(getApplicationContext(), ChooseAreaActivity.class);
                startActivity(intent);
            }
        });

        mVolumeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: VolumeActivity");
                Intent intent = new Intent(getApplicationContext(), ChooseVolumeActivity.class);
                startActivity(intent);
            }
        });

    }


}
