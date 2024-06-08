package com.example.currency_lab2;

import java.util.concurrent.ThreadLocalRandom;

public class Currency {
    private Double price;
    private Integer day;

    private final double k;

    public Currency(double price) {
        this.price = price;
        k = ThreadLocalRandom.current().nextDouble(0.018, 0.024);
        day = 0;
    }

    public double getPrice() {
        return price;
    }

    public Integer getDay() {
        return day;
    }

    private double mu = 0.2;
    private double std = 0.3;
    private double dt = 0.1;

    public void updatePrice() {
        day++;
        if (price == null) {
            return;
        }

        double generated = generateRandomNormal();
        price = price * Math.exp((mu - Math.pow(std, 2.0) / 2.0) * dt + Math.sqrt(std) * Math.sqrt(dt) * generated);

    }

    private double generateRandomNormal() {
        double u1 = ThreadLocalRandom.current().nextDouble();
        double u2 = ThreadLocalRandom.current().nextDouble();
        return Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);
    }
}
