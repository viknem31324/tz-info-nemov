package org.example;

import java.util.Objects;

public class City {
    private final String name;
    private int oneFloor = 0;
    private int twoFloor = 0;
    private int threeFloor = 0;
    private int fourFloor = 0;
    private int fiveFloor = 0;

    public City(String name) {
        this.name = name;
    }

    public City(String name, int oneFloor, int twoFloor, int threeFloor, int fourFloor, int fiveFloor) {
        this.name = name;
        this.oneFloor = oneFloor;
        this.twoFloor = twoFloor;
        this.threeFloor = threeFloor;
        this.fourFloor = fourFloor;
        this.fiveFloor = fiveFloor;
    }

    public String getName() {
        return name;
    }

    public int getOneFloor() {
        return oneFloor;
    }

    public int getTwoFloor() {
        return twoFloor;
    }

    public int getThreeFloor() {
        return threeFloor;
    }

    public int getFourFloor() {
        return fourFloor;
    }

    public int getFiveFloor() {
        return fiveFloor;
    }

    public void setOneFloor() {
        this.oneFloor += 1;
    }

    public void setTwoFloor() {
        this.twoFloor += 1;
    }

    public void setThreeFloor() {
        this.threeFloor += 1;
    }

    public void setFourFloor() {
        this.fourFloor += 1;
    }

    public void setFiveFloor() {
        this.fiveFloor += 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City otherCity = (City) obj;

        return Objects.equals(name, otherCity.getName()) &&
                (oneFloor == otherCity.getOneFloor()) &&
                (twoFloor == otherCity.getTwoFloor()) &&
                (threeFloor == otherCity.getThreeFloor()) &&
                (fourFloor == otherCity.getFourFloor()) &&
                (fiveFloor == otherCity.getFiveFloor());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null) {
            hash = hash + name.hashCode();
        }

        hash = hash * 31 + oneFloor + twoFloor + threeFloor + fourFloor + fiveFloor;

        return hash;
    }

    @Override
    public String toString() {
        String result = "City{" +
                "Название города='" + name + '\'' +
                ", Одноэтажных='" + oneFloor + '\'' +
                ", Двухэтажных=" + twoFloor + '\'' +
                ", Трехэтажных=" + threeFloor + '\'' +
                ", Четырехэтажных=" + fourFloor + '\'' +
                ", Пятиэтажных=" + fiveFloor + '\'';

        return result + "}";
    }
}
