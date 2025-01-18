package MoneyCalculator;

import org.example.Controller.Controller;
import org.example.Model.Currency;
import org.example.Model.Persistence.FileLoader;
import org.example.View.View;

public class Main {
    public static void main(String[] args) {
        FileLoader file = new FileLoader("src/main/resources/currencies.txt");
        String[] arr = toArrayString(file);
        View vista = new View(arr, file.getCurrencies());
        Controller controller = new Controller(vista, file.getCurrencies());
    }

    private static String[] toArrayString(FileLoader file) {
        Currency[] arr = file.getCurrencies();
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i].getName();
        }
        return res;
    }
}
