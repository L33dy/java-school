package week4;

import java.util.ArrayList;
import java.util.List;

public class EshopImpl implements Eshop {

    private List<Product> products;

    public EshopImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public Cart createCart() {
        return new Cart();
    }

    @Override
    public void addToCart(Cart cart, String productCode) {
        Product product = getProduct(productCode);
        if (product != null && product.isAvailable()) {
            cart.add(product);
        }
    }

    public Product getProduct(String productCode) {
        for (Product product : this.products) {
            if (productCode.equals(product.getCode())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void register(Product product) {
        this.products.add(product);
    }

    @Override
    public double getAveragePrice() {
        if (this.products.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Product product : this.products) {
            sum += product.getPrice();
        }
        return sum / this.products.size();
    }

    @Override
    public List<Product> getProducts(double min, double max) {
        List<Product> result = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public double pay(Cart cart) {
        return cart.getPrice();
    }

    @Override
    public void deleteFromCart(Cart cart, String productCode) {
        Product product = getProduct(productCode);
        if (product != null) {
            cart.delete(product);
        }
    }



    @Override
    public String toString() {
        return "EshopImpl{" +
                "products=" + products +
                '}';
    }
}
