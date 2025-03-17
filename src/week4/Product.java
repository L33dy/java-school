package week4;

import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private String code;
    private int availableItems;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Product(String name, double price, String code, int availableItems) {
        this.name = name;
        setPrice(price);
        this.code = code;
        setAvailableItems(availableItems);
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setAvailableItems(int availableItems) {
        if (availableItems < 0) {
            this.availableItems = 0;
        } else {
            this.availableItems = availableItems;
        }
    }

    public String getName() {
        return name;
    }



    public String getCode() {
        return code;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public boolean isAvailable() {
        return this.availableItems > 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                ", availableItems=" + availableItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && availableItems == product.availableItems && Objects.equals(name, product.name) && Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, code, availableItems);
    }
}
