package com.company.Commands;

import com.company.*;
import java.util.ArrayList;

public class SortCarsByFuel extends Command {
    public SortCarsByFuel(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nSort cars by  fuel:\n");
        ArrayList<Car>  cars = getAllCars();
        cars.sort(new CarFuelComparison());
        for (Car car : cars) System.out.println(car);

    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
           cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }
}


