package com.company;

public class CarPriceComparison implements java.util.Comparator<Car> {

    public int compare(Car car1, Car  car2) {
        return ( car1.getCarPrice() -  car2.getCarPrice());
    }
}