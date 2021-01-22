package com.company.Commands;

import com.company.Car;
import com.company.Taxpark;
import com.company.Control;
import java.util.ArrayList;

public class OverallFuel extends Command {
    public OverallFuel (Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        int totalFuel = 0;
        ArrayList<Car> cars = getAllCars();
        for (Car car : cars) {
            totalFuel = totalFuel + car.getCarFuel();
        }
        System.out.println("\nOverallt speed of all cars: " + totalFuel + "Litters");
    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
            cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }
}
