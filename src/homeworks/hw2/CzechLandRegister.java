package homeworks.hw2;

import java.util.List;

public class CzechLandRegister implements LandRegister {
    public List<Property> properties;

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
    }

    @Override
    public int getPropertyCount(Owner owner) {
        return 0;
    }
}
