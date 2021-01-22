package com.company.Commands;

import com.company.Control;
import com.company.Taxpark;
import com.company.Car;
import com.company.CarPriceComparison;
import java.util.ArrayList;

public class SortCarsByValue extends Command {
    public SortCarsByValue(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nSorted cars by value:\n");
        ArrayList<Car> cars = getAllCars();
        cars.sort(new CarPriceComparison());
        for (Car car : cars) System.out.println(car);

    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car>cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
            cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }
}


