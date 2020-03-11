package com.example.calcapplication.LinearFunction;

public class CalcLinearFunction {

    private double paramA;
    private double paramB;

    public CalcLinearFunction(double paramA, double paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public double getZeroPlace() {

        double resultParam ;
        resultParam = (-paramB/paramA);

        return resultParam;
    }


}
