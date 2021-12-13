package vendingmachine.repository;

import java.util.ArrayList;

public class Products {

    private ArrayList<Product> products;

    public Products(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(String name){
        for (Product product: products){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public int getLowestPrice(){
        int lowestPrice = products.get(0).getPrice();
        for (Product product: products){
            if (product.isLowerPrice(lowestPrice)){
                lowestPrice = product.getPrice();
            }
        }
        return lowestPrice;
    }
}
