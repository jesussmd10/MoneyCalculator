package org.example.Model.Persistence;

import org.example.Model.Currency;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader implements PersistenceMethods {

    private final String fileName;

    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Currency[] getCurrencies() {
        ArrayList<Currency> arr = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                arr.add(createCurrency(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr.toArray(new Currency[0]);
    }

    private Currency createCurrency(String line) {
        String[] object = line.split(",");
        return new Currency(object[0], object[1], object[2]);
    }
}
