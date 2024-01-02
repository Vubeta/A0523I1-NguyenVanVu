package com.example.test_demo.model;

public class CurrencyConversion {
    private double exchangeRate;
    private double usdAmount;
    private double vndAmount;

    public CurrencyConversion(double exchangeRate, double usdAmount, double vndAmount) {
        this.exchangeRate = exchangeRate;
        this.usdAmount = usdAmount;
        this.vndAmount = vndAmount;
    }

    public CurrencyConversion() {
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getUsdAmount() {
        return usdAmount;
    }

    public void setUsdAmount(double usdAmount) {
        this.usdAmount = usdAmount;
    }

    public double getVndAmount() {
        return vndAmount;
    }

    public void setVndAmount(double vndAmount) {
        this.vndAmount = vndAmount;
    }
}
