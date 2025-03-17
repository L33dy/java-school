package week4.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week4.Cart;
import week4.EshopImpl;
import week4.Product;

class EshopImplTest {

    @Test
    void createCart() {
        EshopImpl eshop = new EshopImpl();

        Cart cart = eshop.createCart();

        Assertions.assertInstanceOf(Cart.class, cart);
    }

    @Test
    void addToCart() {
        EshopImpl eshop = new EshopImpl();
        Cart cart = eshop.createCart();
        Product product = new Product("Apple", 10, "apple-01", 10);

        eshop.register(product);

        eshop.addToCart(cart, product.getCode());

        Assertions.assertEquals(1, cart.getSize());
    }

    @Test
    void register() {
        EshopImpl eshop = new EshopImpl();
        Product product = new Product("Apple", 10, "apple-01", 10);

        eshop.register(product);

        Assertions.assertNotNull(eshop.getProduct(product.getCode()));
    }

    @Test
    void getAveragePrice() {
        EshopImpl eshop = new EshopImpl();
        Cart cart = eshop.createCart();
        Product apple = new Product("Apple", 10, "apple-01", 10);
        Product banana = new Product("Banana", 20, "banana-01", 10);

        eshop.register(apple);
        eshop.register(banana);

        eshop.addToCart(cart, apple.getCode());
        eshop.addToCart(cart, banana.getCode());

        Assertions.assertEquals(15, eshop.getAveragePrice());
    }

    @Test
    void getProducts() {
        EshopImpl eshop = new EshopImpl();
        Product apple = new Product("Apple", 10, "apple-01", 10);
        Product banana = new Product("Banana", 20, "banana-01", 10);

        eshop.register(apple);
        eshop.register(banana);

        Assertions.assertEquals(2, eshop.getProducts(10, 20).size());
    }

    @Test
    void pay() {
        EshopImpl eshop = new EshopImpl();
        Cart cart = eshop.createCart();
        Product apple = new Product("Apple", 10, "apple-01", 10);

        cart.add(apple);

        Assertions.assertEquals(10, eshop.pay(cart));
    }

    @Test
    void deleteFromCart() {
        EshopImpl eshop = new EshopImpl();
        Cart cart = eshop.createCart();
        Product apple = new Product("Apple", 10, "apple-01", 10);

        cart.add(apple);

        Assertions.assertEquals(1, cart.getSize());

        cart.delete(apple);

        Assertions.assertEquals(0, cart.getSize());
    }
}