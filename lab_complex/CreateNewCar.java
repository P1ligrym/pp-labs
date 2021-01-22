package com.company.Commands;

import com.company.Control;
import com.company.Car;
import com.company.Taxpark;
import java.util.logging.Logger;
import java.util.Scanner;

public class CreateNewCar extends Command {
    private final Logger LOGGER = Logger.getLogger(CreateNewCar.class.getName());

    public CreateNewCar(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {

        String carName = inputString("Please enter a car name:");
        if (carName == null || carName.equals("")) {
            LOGGER.warning("Taxpark name could not be an empty row !");
            return;
        }
        int carId = inputId();
        if (carId <= 0) {
            LOGGER.warning("Car ID has to be in range of 1 to 100!");
            return;
        }
        int carFuel = inputFuel();
        if (carFuel <= 0) {
            LOGGER.warning("Fuel of the car has to be a positive value !");
            return;
        }
        int carPrice = inputPrice();
        if (carPrice <= 0) {
            LOGGER.warning("Price has to be a positive value !");
            return;
        }
        int carSpeed = inputSpeed();
        if (carSpeed > 400) {
            LOGGER.warning("Speed could only have 400km/h !");
            return;
        }
        String taxparkName = inputString("Enter to which taxpark this car belongs: ");
        Taxpark tempTaxpark = findTaxpark(taxparkName);
        if (tempTaxpark == null) {
            LOGGER.warning("\nUnable to find this Taxpark...");
            return;
        }
        Car tempCar = new Car(carName, carId, carFuel, carPrice, carSpeed);
        tempTaxpark.addCarToTaxpark(tempCar);
        System.out.println("\nCar has been successfully created! ");
    }

    private Taxpark findTaxpark(String taxparkName) {
        for (Taxpark elem : control.getTaxpark()) {
            if (elem.getTaxparkName().equalsIgnoreCase(taxparkName)) return elem;
        }
        return null;
    }

    private static int inputId() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter car Id:");
        return scan.nextInt();
    }

    private static int inputFuel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter car fuel in litters:");
        return scan.nextInt();
    }

    private static int inputPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter car price($):");
        return scan.nextInt();
    }

    private static int inputSpeed() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter car speed:");
        return scan.nextInt();
    }

    private static String inputString(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + str);
        return scan.nextLine();
    }
}
