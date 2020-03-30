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

    private final String TAG = "QuadraticActivity";

    private EditText qParamA;
    private EditText qParamB;
    private EditText qParamC;
    private TextView qParamResultX1;
    private TextView qParamResultX2;
    private TextView qParamDeltaResult;
    private TextView qFunctionMonoInfo1;
    private TextView qFunctionMonoInfo2;
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
        qFunctionMonoInfo1 = findViewById(R.id.function_quadratic_mono1);
        qFunctionMonoInfo2 = findViewById(R.id.function_quadratic_mono2);
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
                    //initiate constructor of Quadratic function
                    calcQuadraticFunction = new CalcQuadraticFunction(Double.parseDouble(mParamA),Double.parseDouble(mParamB),Double.parseDouble(mParamC));

                    //delta
                    double deltaResult = calcQuadraticFunction.calcDelta();

                    if(calcQuadraticFunction.getParamA() != 0 ) {
                        if(deltaResult > 0) {

                            //x1 and x2 value
                            double x1 = calcQuadraticFunction.calcX1();
                            double x2 = calcQuadraticFunction.calcX2();

                            //visibility if before paramA was 0
                            setViewVisibility(qParamResultX1);
                            setViewVisibility(qParamResultX2);
                            setViewVisibility(qParamDeltaResult);
                            setViewVisibility(qFunctionMonoInfo1);
                            setViewVisibility(qFunctionMonoInfo2);

                            // Calc delta, x1,x2
                            qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                            qParamResultX1.setText(String.format("%s%s","X1 = ", x1));
                            qParamResultX2.setText(String.format("%s%s","X2 = ", x2));

                            // Set Monotonicity
                            qFunctionMonoInfo1.setText(calcQuadraticFunction.getMonotonicity().get(0).toString());
                            qFunctionMonoInfo2.setText(calcQuadraticFunction.getMonotonicity().get(1).toString());


                        } else if ( deltaResult == 0 ) {

                            // x0 value
                            double x0 = calcQuadraticFunction.calcX0();

                            //visibility if before paramA was 0
                            setViewGone(qParamResultX2);
                            setViewVisibility(qFunctionMonoInfo1);
                            setViewVisibility(qFunctionMonoInfo2);
                            setViewVisibility(qParamDeltaResult);
                            setViewVisibility(qParamResultX1);

                            // Calc delta and x0,
                            // x0 put in same field what x1
                            qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                            qParamResultX1.setText(String.format("%s%s",getString(R.string.zero_place),x0));

                            // Set Monotonicity
                            qFunctionMonoInfo1.setText(calcQuadraticFunction.getMonotonicity().get(0).toString());
                            qFunctionMonoInfo2.setText(calcQuadraticFunction.getMonotonicity().get(1).toString());


                        } else {

                            //visibility if before paramA was 0
                            setViewVisibility(qFunctionMonoInfo1);
                            setViewVisibility(qFunctionMonoInfo2);
                            setViewVisibility(qParamDeltaResult);
                            setViewVisibility(qParamResultX1);
                            setViewVisibility(qParamResultX2);

                            // Calc delta and set x1,x2
                            qParamDeltaResult.setText(String.format("%s%s","delta = ",deltaResult));
                            qParamResultX1.setText(R.string.lack_zero_x1);
                            qParamResultX2.setText(R.string.lack_zero_x2);

                            // Set Monotonicity
                            qFunctionMonoInfo1.setText(calcQuadraticFunction.getMonotonicity().get(0).toString());
                            qFunctionMonoInfo2.setText(calcQuadraticFunction.getMonotonicity().get(1).toString());
                        }


                    } else {

                        // visibility gone cause paramA ==0 -> is not quadratic !
                        setViewGone(qParamDeltaResult);
                        setViewGone(qParamResultX1);
                        setViewGone(qParamResultX2);
                        setViewGone(qFunctionMonoInfo2);

                        //set info about not quadratic
                        qFunctionMonoInfo1.setText(R.string.not_quadratic_function);

                    }
                }

            }
        });

    }

    public void setViewVisibility(TextView tv) {

        if(tv.getVisibility()==View.GONE) {
            tv.setVisibility(View.VISIBLE);
        }

    }

    public void setViewGone(TextView tv) {

        if(tv.getVisibility()==View.VISIBLE) {
            tv.setVisibility(View.GONE);
        }

    }



}
