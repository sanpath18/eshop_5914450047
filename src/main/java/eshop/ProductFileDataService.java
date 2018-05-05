package eshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFileDataService implements IDataService {
    @Override
    public Iterator getAllObjects() {
        List<Product> products = new ArrayList<>();
        try {
            FileReader file = new FileReader("product.csv");
            BufferedReader in = new BufferedReader(file);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File product.csv cannot be found");
        } catch (IOException e) {
            System.err.println("Error reading file product.csv");
            e.printStackTrace();
        }
        return products.iterator();
    }
}
