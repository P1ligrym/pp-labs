package com.company.Commands;

import com.company.Control;
import com.company.Taxpark;
import java.util.logging.Logger;
import java.util.Scanner;

public class CreateNewTaxpark extends Command {
    private final Logger LOGGER = Logger.getLogger(CreateNewTaxpark.class.getName());

    public CreateNewTaxpark(Control control) {
        this.control = control;

    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter a taxpark name: ");
        String taxparkName = scan.nextLine();
        if (taxparkName == null || taxparkName.equals("")) {
            LOGGER.warning("Unable to create a taxpark with the same name !");
            return;
        }
        if (findTaxpark(taxparkName) != null)
            LOGGER.warning("This taxpark already exists !");

        control.getTaxpark().add(new Taxpark(taxparkName));
        System.out.println("\nTaxpark has been successfully created!");

    }

    private Taxpark findTaxpark(String TaxparkName) {
        for (Taxpark elem : control.getTaxpark()) {
            if (elem.getTaxparkName().equalsIgnoreCase(TaxparkName)) return elem;
        }
        return null;
    }
}
