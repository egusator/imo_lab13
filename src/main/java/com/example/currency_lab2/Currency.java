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

    public void updatePriceForNextDay() {
        day++;
        if (price == null) {
            return;
        } else {
            price = price * (1 + k * ( ThreadLocalRandom.current().nextDouble(0, 1) - 0.5));
        }
    }
}
