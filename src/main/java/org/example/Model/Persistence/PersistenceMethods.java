package org.example.Model.Persistence;

import org.example.Model.Currency;

public interface PersistenceMethods {
    /**
     * This method creates an array with the Currencies written in the textFile:
     * Attribute of FileLoader.
     */
    Currency[] getCurrencies();
    
}
