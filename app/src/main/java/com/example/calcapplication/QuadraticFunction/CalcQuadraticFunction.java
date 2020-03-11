package com.example.calcapplication.QuadraticFunction;

public class CalcQuadraticFunction {

    private double paramA;
    private double paramB;
    private double paramC;

    public CalcQuadraticFunction(double paramA, double paramB, double paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }


    public double getParamA() {
        return paramA;
    }

    public void setParamA(double paramA) {
        this.paramA = paramA;
    }

    public double getParamB() {
        return paramB;
    }

    public void setParamB(double paramB) {
        this.paramB = paramB;
    }

    public double getParamC() {
        return paramC;
    }

    public void setParamC(double paramC) {
        this.paramC = paramC;
    }

    public double calcDelta() {

        return (Math.pow(getParamB(), 2)) - 4 * getParamA() * getParamC();
    }

    public double calcX0() {

        return -getParamB() / 2 * getParamA();
    }

    public double calcX1() {

        return (-getParamB() - calcDelta()) / 2 * getParamA();
    }

    public double calcX2() {

        return (-getParamB() + calcDelta()) / 2 * getParamA();
    }

    public double calcTopP() {

        return -getParamB() / 2 * getParamA();
    }

    public double calcTopQ() {

        return -calcDelta() / 4 * getParamA();
    }


}
