package com.company;

import java.util.Objects;

public class Car {

    private Taxpark taxpark;

    private static int CarIdCounter = 1;

    private final String CarName;

    private final int CarId;

    private final int CarFuel;

    private final int CarPrice;

    private final int CarSpeed;

    public Car(String CarName, int CarId, int CarFuel, int CarPrice, int CarSpeed) {
        CarId = CarIdCounter++;
        this.CarName = CarName;
        this.CarId = CarId;
        this.CarFuel = CarFuel;
        this.CarPrice = CarPrice;
        this.CarSpeed = CarSpeed;

    }

    public String getCarName() {
        return CarName;
    }

    public int getCarId() {
        return CarId;
    }

    public int getCarFuel() {
        return CarFuel;
    }

    public int getCarPrice() {
        return CarPrice;
    }

    public int getCarSpeed() { return CarSpeed; }

    public void RemoveCarFromTaxpark() {
        taxpark = null;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarName = " + CarName +
                ", CarId = " + CarId +
                ", CarFuel = " + CarFuel + " litters" +
                ", CarPrice = " +CarPrice + " $" +
                ", CarSpped = " + CarSpeed +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        if (CarId != car.CarId) return false;
        if (CarFuel != car.CarFuel) return false;
        if (!CarName.equals(car.CarName)) return false;
        return Objects.equals(taxpark, car.taxpark);
    }
}
