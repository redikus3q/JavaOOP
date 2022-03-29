package Entities;

public class Venue {
    String name;
    int capacity;
    Address address;

    public Venue(String name, int capacity, Address address) {
        name = name;
        this.capacity = capacity;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
