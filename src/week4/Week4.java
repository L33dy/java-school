package week4;

import base.Week;

public class Week4 extends Week {
    public void run() {
        Product p1 = new Product("Jablko", 10, "apple-01", 20);
        Product p2 = new Product("Jablko", 10, "apple-01", 20);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}