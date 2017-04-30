package com.example;

/**
 * Created by User on 30-Apr-17.
 */
public class Swedbank implements BankLeasing {
    double sum;
    double period;
    double intress;

    public Swedbank(double sum, double period, double intress) {
        this.sum = sum;
        this.period = period;
        this.intress = intress;
    }


    @Override
    public double Leasing() {
        double i = intress / 12 / 100;

        return (i * Math.pow(1+i,period) / (Math.pow(1+i,period) - 1)) * sum;

    }
}
