package ru.job4j.stream;

import java.util.Objects;

public class Address {
    public String getCity() {
        return city;
    }

    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city) {
        this.city = city;
        this.street = "test";
        this.home = 1;
        this.apartment = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(getCity(), address.getCity())
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), street, home, apartment);
    }
}
