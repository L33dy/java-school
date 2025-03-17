package week4;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    private Set<Product> products;

    public Cart() {
        this.products = new HashSet<>();
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void delete(Product product) {
        this.products.remove(product);
    }

    public double getPrice() {
        double result = 0;
        for (Product product : this.products) {
            result += product.getPrice();
        }
        return result;
    }

    public int getSize() {
        return products.size();
    }
}
