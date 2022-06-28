package pl.javaskills.creditapp.core.model;

import java.util.Objects;

public class Address {
    private final String street;
    private final String city;
    private final String houseNumber;
    private final String zipCode;
    private final String state;

    public Address(String street, String city, String houseNumber, String zipCode, String state) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street)
                && Objects.equals(city, address.city)
                && Objects.equals(houseNumber, address.houseNumber)
                && Objects.equals(zipCode, address.zipCode)
                && Objects.equals(state, address.state);
    }

}
