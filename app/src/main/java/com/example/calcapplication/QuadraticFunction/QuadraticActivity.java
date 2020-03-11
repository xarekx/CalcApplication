package com.example.calcapplication.QuadraticFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcapplication.R;

public class QuadraticActivity extends AppCompatActivity {

    private EditText qParamA;
    private EditText qParamB;
    private EditText qParamC;
    private TextView qParamResultX1;
    private TextView qParamResultX2;
    private TextView qParamDeltaResult;
    private TextView qFunctionInfo;
    private Button qCalcButton;
    CalcQuadraticFunction calcQuadraticFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        qParamA = findViewById(R.id.param_quadratic_a);
        qParamB = findViewById(R.id.param_quadratic_b);
        qParamC = findViewById(R.id.param_quadratic_c);
        qParamResultX1 = findViewById(R.id.param_quadratic_result_x1);
        qParamResultX2 = findViewById(R.id.param_quadratic_result_x2);
        qParamDeltaResult = findViewById(R.id.param_quadratic_delta_result);
        qFunctionInfo = findViewById(R.id.function_quadratic_info);
        qCalcButton = findViewById(R.id.button_quadratic_calc);



        qCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mParamA = qParamA.getText().toString();
                String mParamB = qParamB.getText().toString();
                String mParamC = qParamC.getText().toString();


                if(qParamA.getText().toString().equals("") || qParamB.getText().toString().equals("") || qParamC.getText().toString().equals("")) {

                    Toast.makeText(QuadraticActivity.this, "Parameter A,B or C is empty", Toast.LENGTH_SHORT).show();

                } else {
                    calcQuadraticFunction = new CalcQuadraticFunction(Double.parseDouble(mParamA),Double.parseDouble(mParamB),Double.parseDouble(mParamC));
                    System.out.println(calcQuadraticFunction);
                    double deltaResult = calcQuadraticFunction.calcDelta();

                    if(deltaResult > 0) {

                        //visibility of x1,x2 ( needed to return x2 when first delta was 0 )
                        if (qParamResultX2.getVisibility()==View.GONE) {
                            qParamResultX2.setVisibility(View.VISIBLE);
                        }
                        double x1 = calcQuadraticFunction.calcX1();
                        double x2 = calcQuadraticFunction.calcX2();
                        // Calc delta, x1,x2
                        qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                        qParamResultX1.setText(String.format("%s%s","X1 = ", x1));
                        qParamResultX2.setText(String.format("%s%s","X2 = ", x2));


                    } else if ( deltaResult == 0 ) {
                        double x0 = calcQuadraticFunction.calcX0();
                        if(qParamResultX2.getVisibility()==View.VISIBLE) {
                            qParamResultX2.setVisibility(View.GONE);
                        }
                        qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                        qParamResultX1.setText(String.format("%s%s",getString(R.string.zero_place),x0));

                    } else {
                        if (qParamResultX2.getVisibility()==View.GONE) {
                            qParamResultX2.setVisibility(View.VISIBLE);
                        }
                        qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                        qParamResultX1.setText(R.string.lack_zero_x1);
                        qParamResultX2.setText(R.string.lack_zero_x2);
                    }


                }

            }
        });

    }
}
