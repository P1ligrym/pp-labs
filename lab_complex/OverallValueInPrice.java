package com.company.Commands;

import com.company.Car;
import com.company.Taxpark;
import com.company.Control;
import java.util.ArrayList;

public class OverallValueInPrice extends Command {

    public OverallValueInPrice(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        int totalPrice = 0;
        ArrayList<Car> cars = getAllCars();
        for (Car car : cars) {
            totalPrice = totalPrice + car.getCarPrice();
        }
        System.out.println("\nOverall value of all cars: " + totalPrice + " $");
    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
            cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }
}
