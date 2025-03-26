package homeworks.hw2;

import java.util.ArrayList;
import java.util.List;

public class CzechLandRegister implements LandRegister {
    public List<Property> properties = new ArrayList<>();

    @Override
    public void registerProperty(Property property) {
        properties.add(property);
    }

    @Override
    public int getAverageAcreage() {
        int acreageSum = properties.stream().mapToInt(Property::getAcreage).sum();

        return acreageSum / properties.size();
    }

    @Override
    public void changePropertyOwner(Owner newOwner, Property property) {
        int propertyIndex = properties.indexOf(property);

        properties.get(propertyIndex).setOwner(newOwner);
    }

    @Override
    public int getPropertyCount(Owner owner) {
        int propertyCount = (int) properties.stream().filter(p -> p.getOwners().contains(owner)).count();

        return propertyCount;
    }
}
