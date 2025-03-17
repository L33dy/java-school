package week4;

import java.util.List;

public interface Eshop {
    Cart createCart();

    void addToCart(Cart cart, String productCode);

    double pay(Cart cart);

    void deleteFromCart(Cart cart, String productCode);

    void register(Product product);

    double getAveragePrice();
    List<Product> getProducts(double min, double max);
}
