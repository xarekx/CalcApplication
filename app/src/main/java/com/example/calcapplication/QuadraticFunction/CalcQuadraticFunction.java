package com.example.calcapplication.QuadraticFunction;

import java.util.ArrayList;

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

        return (-getParamB() - Math.sqrt(calcDelta())) / 2 * getParamA();
    }

    public double calcX2() {

        return (-getParamB() + Math.sqrt(calcDelta())) / 2 * getParamA();
    }

    public double calcTopP() {
        return ((-getParamB()) / (2 * getParamA()));
    }

    public double calcTopQ() {

        return ((-calcDelta()) / (4 * getParamA()));
    }

    //Monotonicity - monotoniczność
    public ArrayList getMonotonicity() {
        ArrayList<String> functionInfo = new ArrayList<>();

        if(getParamA() > 0 && calcDelta()>0) {

            functionInfo.add(String.format("%s%s", "Function is decreasing on (-inf;",calcTopP()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is increasing on (",calcTopQ(),";+inf)"));

        } else if(getParamA() > 0 && calcDelta()==0) {

            functionInfo.add(String.format("%s%s", "Function is decreasing on (-inf;",calcX0()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is increasing on (",calcX0(),";+inf)"));

        }  else if(getParamA() > 0 && calcDelta() < 0) {

            functionInfo.add(String.format("%s%s", "Function is decreasing on (-inf;",calcTopP()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is increasing on (",calcTopQ(),";+inf)"));

        } else if(getParamA() < 0 && calcDelta()>0) {

            functionInfo.add(String.format("%s%s", "Function is increasing on (-inf;",calcTopP()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is decreasing on (",calcTopQ(),";+inf)"));

        } else if(getParamA() < 0 && calcDelta()==0) {

            functionInfo.add(String.format("%s%s", "Function is increasing on (-inf;",calcX0()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is decreasing on (",calcX0(),";+inf)"));

        }  else if(getParamA() < 0 && calcDelta() < 0) {

            functionInfo.add(String.format("%s%s", "Function is increasing on (-inf;",calcTopP()+")"));
            functionInfo.add(String.format("%s%s%s", "Function is decreasing on (",calcTopQ(),";+inf)"));

        } else {

            functionInfo.add(String.format("%s","Function has no monotonicity"));
        }

        return functionInfo;
    }
}

