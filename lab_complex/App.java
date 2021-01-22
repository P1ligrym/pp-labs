package com.company;

import com.company.Commands.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class App {

    private static final Control control = new Control();

    private static final Develop develop = new Develop(
            new CreateNewTaxpark(control),
            new CreateNewCar(control),
            new ListOfCars(control),
            new OverallValueInPrice(control),
            new SortCarsByValue(control),
            new SortCarsByFuel(control),
            new SpeedRange(control)
    );

    public static class MyFilter implements Filter {

        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("IN_FILE");

        }
    }

    static int select;
    static Scanner scanner = new Scanner(System.in);
    static Logger LOGGER = Logger.getLogger(App.class.getName());

    public void Work() throws IOException {
        Handler fileHandler = new LoggerFile().GetFile();
        fileHandler.setFilter(new MyFilter());
        LOGGER.addHandler(fileHandler);

        while (true) {
            printMenu();
            menuCommands();
        }
    }

    private static void printMenu() {
        System.out.println(
                "\n1. CreateNewTaxpark" +
                        "\n2. CreateNewCar" +
                        "\n3. ListOfCars" +
                        "\n4. OverallValueInPrice" +
                        "\n5. SortCarsByValue" +
                        "\n6. SortCarsByFuel" +
                        "\n7. SpeedRange" +
                        "\n8. Exit\n" +
                        "\nSelect Command:");
    }

    private static void menuCommands() {

        select = scanner.nextInt();
        if (select <= 0 || select > 9) {
            LOGGER.warning("The value cannot be less than 0 or greater than 9");
            LOGGER.setUseParentHandlers(false);
            LOGGER.info("An error occurred while selecting the menu itemIN_FILE");
            LOGGER.setUseParentHandlers(true);
        }
        switch (select) {
            case 1 -> develop.CreateNewTaxpark();
            case 2 -> develop.CreateNewCar();
            case 3 -> develop.ListOfCars();
            case 4 -> develop.OverallValueInPrice();
            case 5 -> develop.SortCarsByValue();
            case 6 -> develop.SortCarsByFuel();
            case 7 -> develop.SpeedRange();
            case 8 -> System.exit(0);
        }
    }
}
