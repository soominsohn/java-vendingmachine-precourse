package vendingmachine.service;

import java.util.ArrayList;

import vendingmachine.repository.Product;
import vendingmachine.view.InputView;

public class ProductService {

    InputView inputView = new InputView();
    ProductValidator productValidator = new ProductValidator();

    public ArrayList<Product> generate() {
        while (true) {
            try {
                return replaceString(inputView.getProduct());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<Product> replaceString(String input) {
        ArrayList<Product> products = new ArrayList<>();

        for (String product : splitInput(input)) {
            String[] item = product.split(",");
            productValidator.isValid(item);
            products.add(new Product(item[0],
                Integer.parseInt(item[1]),
                Integer.parseInt(item[2])));
        }
        return products;
}

    public String[] splitInput(String input) {
        return input.replaceAll("\\[", "")
            .replaceAll("]", "")
            .split(";");
    }
}
