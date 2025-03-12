package homeworks.hw2;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private String address;
    private int acreage;
    private List<Owner> owners;

    public Property(String address, int acreage, List<Owner> owners) {
        this.address = address;
        this.acreage = acreage;
        this.owners = (owners != null) ? new ArrayList<>(owners) : new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public int getAcreage() {
        return acreage;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwner(Owner owner) {
        owners.add(owner);
    }
}
