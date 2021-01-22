package com.company;

import com.company.Commands.*;

public class Develop {
    Command _CreateNewTaxpark;
    Command _CreateNewCar;
    Command _ListOfCars;
    Command _OverallValueInPrice;
    Command _SortCarsByValue;
    Command _SortCarsByFuel;
    Command _SpeedRange;

    public Develop(Command CreateNewTaxpark, Command CreateNewCar,
                   Command ListOfCars,
                  Command OverallValueInPrice,
                   Command SortCarsByValue,
                   Command SortCarsByFuel,
                   Command TransparencyRange
    ) {
        this._CreateNewTaxpark = CreateNewTaxpark;
        this._CreateNewCar = CreateNewCar;
        this._ListOfCars = ListOfCars;
        this._OverallValueInPrice = OverallValueInPrice;
        this._SortCarsByValue = SortCarsByValue;
        this._SortCarsByFuel = SortCarsByFuel;
        this._SpeedRange = TransparencyRange;

    }

    public void CreateNewTaxpark() {
        this._CreateNewTaxpark.execute();
    }

    public void CreateNewCar() {
        this._CreateNewCar.execute();
    }

    public void ListOfCars() {
        this._ListOfCars.execute();
    }

    public void OverallValueInPrice() {
        this._OverallValueInPrice.execute();
    }

    public void SortCarsByValue() {
        this._SortCarsByValue.execute();
    }

    public void SortCarsByFuel() {
        this._SortCarsByFuel.execute();
    }

    public void SpeedRange() {
        this._SpeedRange.execute();
    }
}
