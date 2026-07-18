package com.example.demo;

public class Statistic {
    public int count = 0;
    public double sum = 0.00;
    public double avg = 0.00;
    public double min = 0.00;
    public double max = 0.00;

    public Statistic() {

    }

    public Statistic(int count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return this.avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
