package com.example.calcapplication.LinearFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcapplication.R;

public class LinearActivity extends AppCompatActivity {

    private final String TAG = "LinearActivity";

    private EditText paramA;
    private EditText paramB;
    private TextView paramResult;
    private TextView functionInfo;
    private Button calcButton;
    CalcLinearFunction calcLinearFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        paramA = findViewById(R.id.param_linear_a);
        paramB = findViewById(R.id.param_linear_b);
        paramResult = findViewById(R.id.param_linear_result);
        calcButton = findViewById(R.id.button_linear_calc);
        functionInfo = findViewById(R.id.function_linear_info);


        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mParamA = paramA.getText().toString();
                String mParamB = paramB.getText().toString();


                if(paramA.getText().toString().equals("") || paramB.getText().toString().equals("") ) {
                    Toast.makeText(LinearActivity.this, "param A or B is empty", Toast.LENGTH_SHORT).show();
                } else {
                    calcLinearFunction = new CalcLinearFunction(Float.parseFloat(mParamA),Float.parseFloat(mParamB));
                    float result = calcLinearFunction.getZeroPlace();
                    if(Float.isInfinite(result)) {
                        paramResult.setText(R.string.lack_zero_place);
                    } else if(Float.isNaN(result)) {
                        paramResult.setText(R.string.function_constant);
                    } else {
                        paramResult.setText(String.format("%s%s", getString(R.string.zero_place), result));
                    }

                    if(Float.parseFloat(mParamA)>0) {
                        functionInfo.setText(R.string.function_increasing);
                    } else if (Float.parseFloat(mParamA)<0) {
                        functionInfo.setText(R.string.function_decreasing);
                    } else  {
                        functionInfo.setText(R.string.function_const);
                    }

                }


            }
        });




    }
}
