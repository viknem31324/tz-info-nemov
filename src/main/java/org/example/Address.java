package org.example;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int house;
    private int floor;

    public Address(String city, String street, int house, int floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address otherAddress = (Address) obj;

        return Objects.equals(city, otherAddress.getCity()) &&
                Objects.equals(street, otherAddress.getStreet()) &&
                (house == otherAddress.getHouse()) &&
                (floor == otherAddress.getFloor());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (city != null) {
            hash = hash + city.hashCode();
        }
        hash = hash * 31;

        if (street != null) {
            hash = hash + street.hashCode();
        }

        hash = hash + house + floor;

        return hash;
    }

    @Override
    public String toString() {
        String result = "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house + '\'' +
                ", floor=" + floor + '\'';

        return result + "}";
    }
}
