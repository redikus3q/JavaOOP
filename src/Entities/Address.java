package Entities;

public class Address {
    String addressLine;
    final City city;

    public Address(String addressLine, City city) {
        this.addressLine = addressLine;
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public City getCity() {
        return city;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
