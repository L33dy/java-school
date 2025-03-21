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
        /*
        tady je implementovany reseni, kterymu asi budete rozumet vic, to pod tim je vic advanced

        int acreageSum = 0;

        for (Property property : properties) {
            acreageSum += property.getAcreage();
        }*/

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
        /*
        to samy tady, takze feel free to use jakykoliv

        int propertyCount = 0;

        for (Property property : properties) {
            if (property.getOwners().contains(owner)) {
                propertyCount++;
            }
        }*/

        int propertyCount = (int) properties.stream().filter(p -> p.getOwners().contains(owner)).count();

        return propertyCount;
    }
}
