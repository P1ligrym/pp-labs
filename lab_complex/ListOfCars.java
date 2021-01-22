package com.company.Commands;

import com.company.Control;
import com.company.Car;
import com.company.Taxpark;
import java.util.ArrayList;

public class ListOfCars extends Command {
    public ListOfCars(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nList of all cars:");
        for (Car car : getAllCars()) System.out.println(car);
    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
           cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }
}
