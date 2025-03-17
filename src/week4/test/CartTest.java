package week4.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week4.Cart;
import week4.Product;

public class CartTest {
    @Test
    void add() {
        Product product = new Product("Apple", 10, "apple-01", 1);
        Cart cart = new Cart();

        cart.add(product);

        Assertions.assertEquals(1, cart.getSize());

        cart.add(product);

        Assertions.assertEquals(1, cart.getSize());
    }

    @Test
    void remove() {
        Product product = new Product("Apple", 10, "apple-01", 1);
        Cart cart = new Cart();

        cart.add(product);

        cart.delete(product);

        Assertions.assertEquals(0, cart.getSize());
    }

    @Test
    void getPrice() {
        Product product = new Product("Apple", 10, "apple-01", 1);
        Cart cart = new Cart();

        cart.add(product);

        Assertions.assertEquals(product.getPrice(), cart.getPrice());
    }
}
