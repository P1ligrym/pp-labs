package com.company;

import java.util.ArrayList;

public class Control {
    private final ArrayList<Taxpark>taxpark;

    public ArrayList<Taxpark> getTaxpark() {
        return taxpark;
    }

    public Control() {
        taxpark = new ArrayList<>();
    }
}
