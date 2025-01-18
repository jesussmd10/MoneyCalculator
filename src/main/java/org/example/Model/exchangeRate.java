package org.example.Model;

public class exchangeRate {
    private final Currency primary;
    private final Currency final0;
    private final double amount;

    public exchangeRate(Currency primary, Currency final0, double amount) {
        this.primary = primary;
        this.final0 = final0;
        this.amount = amount;
    }

    public Currency getPrimary() {
        return primary;
    }

    public Currency getFinal0() {
        return final0;
    }

    public double getAmount() {
        return amount;
    }  
}
