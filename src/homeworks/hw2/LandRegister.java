package homeworks.hw2;

public interface LandRegister {
    void registerProperty(Property property);
    int getAverageAcreage();
    void changePropertyOwner(Owner newOwner, Property property);
    int getPropertyCount(Owner owner);
}
