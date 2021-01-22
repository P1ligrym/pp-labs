package com.company.Commands;

import com.company.Control;
import com.company.Taxpark;
import com.company.Car;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class SpeedRange extends Command {
    private final Logger LOGGER = Logger.getLogger( SpeedRange.class.getName());

    public  SpeedRange(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        ArrayList<Car>cars = getAllCars();


        int lowerBoundary = inputLower();
        if (lowerBoundary < 1) {
            LOGGER.warning("Lower boundary has to be a positive value...");
            return;
        }
        int upperBoundary = inputUpper();
        if (lowerBoundary >= upperBoundary) {
            LOGGER.warning("Lower boundary has to be smaller than upper boundary");
            return;
        }

        for (Car car : cars) {
            if ( car.getCarSpeed() > lowerBoundary &&  car.getCarSpeed() < upperBoundary) {
                System.out.println("\nStones in given speed range:\n");
                getAllCars();
                System.out.println(car);
            } else {
                System.out.println("\nUnable to find stones in this speed range...");
            }
        }
    }

    private ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Taxpark taxpark : control.getTaxpark()) {
           cars.addAll(taxpark.getCarForTaxpark());
        }
        return cars;
    }

    private static int inputLower() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Please enter the lower speed boundary:");
        return scan.nextInt();
    }

    private static int inputUpper() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Please enter the upper speed boundary:");
        return scan.nextInt();
    }
}
