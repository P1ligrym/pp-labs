package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**@author Неуров Святослав
 * @version 2.1
 * */

public class Main {
    /**Поле масив списків всі числа*/
   public ArrayList<Integer> all = new ArrayList<>();

    /**Поле парні числа*/
    public ArrayList<Integer> twins = new ArrayList<>();

    /**Поле непарні числа*/
    public ArrayList<Integer> odds = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        int[] intervals = main.getUserInput(scanner);
        main.getInitialized(intervals);
        main.separateValues();
        Collections.reverse(main.twins);
        main.summOdds();
        main.summTwins();

        Fibonacci fibonacci = new Fibonacci(main.odds.get(main.odds.size() - 1),
                main.twins.get(0));
        int length = main.lenghtFib(scanner);
        fibonacci.generate(length);
        ArrayList<Integer> fibonacciList = fibonacci.getFibonacci();
        main.percentages(fibonacciList);
    }

    /**Метод де ми зчитуємо з клавіатури інтервал
     * @return повертає інтервал*/
    public int[] getUserInput(Scanner in) {
        int[] intervals = new int[2];
        System.out.print("Input a intervals: ");
        intervals[0] = in.nextInt();
        System.out.print("Input a intervals: ");
        intervals[1] = in.nextInt();
        return intervals;
    }

    /**Метод який записує числа в список
     * @param intervals інтервали*/
    public void getInitialized(int intervals[]) {
        for (int i = intervals[0]; i < intervals[1] + 1; i++) {
            this.all.add(i);
        }
        System.out.println("All arrays: " + all);
    }

/**Метод де ми розбираємо всі числа на парні і непарні*/
    public void separateValues() {
        for (int e : all) {
            if (e % 2 == 0) {
                this.twins.add(e);
            } else
                this.odds.add(e);
        }
        System.out.println("Twins array: " + twins);
        System.out.println("Odds array: " + odds);
    }

/**Метод,який шукає суму непарних чисел*/
    public void summOdds(){
        int sum = 0;
        for(int i: odds){
            sum+=i;
        }
        System.out.println("Sum odds is: " + sum);
    }

    /**Метод,який шукає суму парних чисел*/
    public void summTwins(){
        int sum = 0;
        for(int e:twins){
            sum+=e;
        }
        System.out.println("Sum twins is: " + sum);
    }

    /**Метод в якому користувач  вводить довжину ряду Фібоначчі
     * @return довжину*/
    public int lenghtFib(Scanner scanner){
        System.out.print("Enter lenght: ");
        int length = scanner.nextInt();
        scanner.close();
        return length;
    }

    /**Метод,який виводить відсоток парних і  непарних чисел
     * @param percentages відсоток парних і непарних чисел*/
    public void percentages(ArrayList<Integer> percentages){
        double twin = 0;
        double odds = 0;
        for(int i : percentages){
            if(i % 2 == 0){
                twin++;

            }else
                odds++;
        }
        System.out.println("Twins: " + twin/(percentages.size())*100 + '%');
        System.out.println("Odds: " + odds/(percentages.size())*100+ '%');
    }
}
















