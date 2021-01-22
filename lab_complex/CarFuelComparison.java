package com.company;

public class CarFuelComparison implements java.util.Comparator<Car> {

    public int compare(Car car1, Car car2) {
        return (car1.getCarFuel() - car2.getCarFuel());
    }
}