package com.company;

import java.util.ArrayList;

public class Taxpark{
    private final String TaxparkName;

    private final ArrayList<Car> carsForTaxpark;

    public Taxpark(String TaxparkName) {
        if (TaxparkName == null || TaxparkName.equals(""))
            throw new IllegalArgumentException("Unable to Create a Taxpark with the same name!");
        this.TaxparkName = TaxparkName;
        this.carsForTaxpark = new ArrayList<>();
    }

    public void addCarToTaxpark(Car car) {
        if (car == null) throw new IllegalArgumentException("Unable to add an empty car !");
        if (!checkCarExists(car)) carsForTaxpark.add(car);
    }

    public void deletCar(Car car) {
        if (car == null) throw new IllegalArgumentException("Unable to delete a missing car!");
        if (checkCarExists(car)) carsForTaxpark.remove(car);
    }

    public String getTaxparkName() {
        return TaxparkName;
    }

    public ArrayList<Car> getCarForTaxpark() {
        return carsForTaxpark;
    }

    private boolean checkCarExists(Car car) {
        for (Car st : carsForTaxpark) {
            if (st.equals(car)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Taxpark taxpark = (Taxpark) obj;

        return TaxparkName.equalsIgnoreCase(taxpark.TaxparkName);
    }

    @Override
    public String toString() {
        return TaxparkName;
    }
}
