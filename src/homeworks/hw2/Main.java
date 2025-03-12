package homeworks.hw2;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        CzechLandRegister c = new CzechLandRegister();

        Owner adam = new Owner("Adam", "Nový");
        Owner petr = new Owner("Petr", "Petrov");

        Property prop1 = new Property("a", 15, Collections.singletonList(adam));
        Property prop2 = new Property("b", 20, Collections.singletonList(petr));

        c.registerProperty(prop1);
        c.registerProperty(prop2);

        c.changePropertyOwner(adam, prop2);

        System.out.println(c.getAverageAcreage());
        System.out.println(c.getPropertyCount(adam));
    }
}
