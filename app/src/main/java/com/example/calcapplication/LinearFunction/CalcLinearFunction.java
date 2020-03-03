package com.example.calcapplication.LinearFunction;

public class CalcLinearFunction {

    private float paramA;
    private float paramB;

    public CalcLinearFunction(float paramA, float paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public float getZeroPlace() {

        float resultParam ;
        resultParam = (-paramB/paramA);

        return resultParam;
    }


}
