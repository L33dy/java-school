package homeworks.hw2.tests;

import homeworks.hw2.CzechLandRegister;
import homeworks.hw2.Owner;
import homeworks.hw2.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CzechLandRegisterTest {
    @Test
    void registerProperty() {
        CzechLandRegister register = new CzechLandRegister();
        Property property1 = new Property("Národní třída", 150, new ArrayList<>());

        Assertions.assertEquals(0, register.properties.size());

        register.registerProperty(property1);

        Assertions.assertEquals(1, register.properties.size());
    }

    @Test
    void getAverageAcreage() {
        CzechLandRegister register = new CzechLandRegister();
        Property property1 = new Property("Dejvická", 100, new ArrayList<>());
        Property property2 = new Property("Národní třída", 200, new ArrayList<>());

        register.registerProperty(property1);
        register.registerProperty(property2);

        Assertions.assertEquals(150, register.getAverageAcreage());
    }

    @Test
    void changePropertyOwner() {
        CzechLandRegister register = new CzechLandRegister();

        Owner owner1 = new Owner("Adam", "Novák");
        Owner owner2 = new Owner("David", "Dlouhý");

        Property property1 = new Property("Dejvická", 100, new ArrayList<>(List.of(owner1)));

        register.registerProperty(property1);

        Assertions.assertIterableEquals(new ArrayList<>(List.of(owner1)), property1.getOwners());

        register.changePropertyOwner(owner2, property1);

        Assertions.assertIterableEquals(new ArrayList<>(List.of(owner1, owner2)), property1.getOwners());
    }

    @Test
    void getPropertyCount() {
        CzechLandRegister register = new CzechLandRegister();

        Owner owner1 = new Owner("Adam", "Novák");

        Property property1 = new Property("Dejvická", 100, new ArrayList<>(List.of(owner1)));

        register.registerProperty(property1);

        Assertions.assertEquals(1, register.getPropertyCount(owner1));
    }
}
