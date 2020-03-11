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

    private EditText lParamA;
    private EditText lParamB;
    private TextView lParamResult;
    private TextView lFunctionInfo;
    private Button lCalcButton;
    CalcLinearFunction calcLinearFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        lParamA = findViewById(R.id.param_linear_a);
        lParamB = findViewById(R.id.param_linear_b);
        lParamResult = findViewById(R.id.param_linear_result);
        lFunctionInfo = findViewById(R.id.function_linear_info);
        lCalcButton = findViewById(R.id.button_linear_calc);


        lCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mParamA = lParamA.getText().toString();
                String mParamB = lParamB.getText().toString();


                if(lParamA.getText().toString().equals("") || lParamB.getText().toString().equals("") ) {
                    Toast.makeText(LinearActivity.this, "param A or B is empty", Toast.LENGTH_SHORT).show();
                } else {
                    calcLinearFunction = new CalcLinearFunction(Double.parseDouble(mParamA),Double.parseDouble(mParamB));
                    double result = calcLinearFunction.getZeroPlace();
                    if(Double.isInfinite(result)) {
                        lParamResult.setText(R.string.lack_zero_place);
                    } else if(Double.isNaN(result)) {
                        lParamResult.setText(R.string.function_constant);
                    } else {
                        lParamResult.setText(String.format("%s%s", getString(R.string.zero_place), result));
                    }

                    if(Double.parseDouble(mParamA)>0) {
                        lFunctionInfo.setText(R.string.function_increasing);
                    } else if (Double.parseDouble(mParamA)<0) {
                        lFunctionInfo.setText(R.string.function_decreasing);
                    } else  {
                        lFunctionInfo.setText(R.string.function_const);
                    }

                }


            }
        });




    }
}
