package org.example.Model.Persistence;

import org.example.Model.Currency;
import org.example.Model.exchangeRate;

public interface ExchangeRateMethods {
    exchangeRate load(Currency from, Currency to);
}
